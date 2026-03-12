package org.knp.bingeboard.data.repository

import kotlinx.coroutines.flow.first
import org.knp.bingeboard.data.api.TvdbApiService
import org.knp.bingeboard.data.model.TvdbEpisodesResponse
import org.knp.bingeboard.data.model.TvdbSearchResponse
import org.knp.bingeboard.data.model.TvdbSeries
import org.knp.bingeboard.data.model.TvdbSeriesResponse
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvdbRepository @Inject constructor(
    private val apiService: TvdbApiService,
    private val userPreferencesRepository: UserPreferencesRepository
) {

    /**
     * Converts user language code (e.g. "en-US") to TVDB 3-letter code (e.g. "eng").
     */
    private fun toTvdbLanguageCode(userLang: String): String {
        val iso2 = userLang.split("-").first().lowercase()
        return LANGUAGE_MAP[iso2] ?: "eng"
    }

    suspend fun searchSeries(query: String): Result<TvdbSearchResponse> {
        return try {
            Result.success(apiService.search(query = query, type = "series"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Gets series details using extended endpoint. Translations are natively embedded.
     */
    suspend fun getSeries(id: Int): Result<TvdbSeriesResponse> {
        return try {
            val response = apiService.getSeries(id)
            val series = response.data ?: return Result.success(response)

            val lang = userPreferencesRepository.language.first()
            val tvdbLang = toTvdbLanguageCode(lang)

            val nameTranslation = series.translations?.nameTranslations?.find { it.language == tvdbLang }?.name
            val overviewTranslation = series.translations?.overviewTranslations?.find { it.language == tvdbLang }?.overview

            val translated = series.copy(
                name = nameTranslation ?: series.name,
                overview = overviewTranslation ?: series.overview
            )
            Result.success(TvdbSeriesResponse(data = translated))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getSeriesEpisodes(id: Int, page: Int = 0): Result<TvdbEpisodesResponse> {
        return try {
            Result.success(apiService.getSeriesEpisodes(id = id, page = page))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /** 
     * Helper to parse TVDB air date ("yyyy-MM-dd") and optional time.
     * Uses the originalCountry to determine the source timezone, and converts to system timezone. 
     */
    fun parseAirDate(dateStr: String?, timeStr: String? = null, originalCountry: String? = null): Long? {
        if (dateStr.isNullOrBlank()) return null
        return try {
            val sourceZone = getZoneIdForCountry(originalCountry)
            
            if (!timeStr.isNullOrBlank()) {
                val cleanTime = timeStr.trim().uppercase()
                try {
                    val formatter = if (cleanTime.contains("AM") || cleanTime.contains("PM")) {
                        java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a")
                    } else {
                        java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd H:m") // H:m handles both 8:00 and 08:00
                    }
                    val localDateTime = java.time.LocalDateTime.parse("$dateStr $cleanTime", formatter)
                    return localDateTime.atZone(sourceZone).toInstant().toEpochMilli()
                } catch (e: Exception) {
                    // Fallback to end of day if time format is unrecognized
                }
            }
            val date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            date.atTime(java.time.LocalTime.MAX).atZone(sourceZone).toInstant().toEpochMilli()
        } catch (e: Exception) {
            null
        }
    }
    
    private fun getZoneIdForCountry(countryCode: String?): java.time.ZoneId {
        if (countryCode.isNullOrBlank()) return java.time.ZoneId.of("America/New_York") // Default to US Eastern as TVDB is US-centric
        
        // Map common 3-letter country codes from TVDB to a representative timezone
        return when (countryCode.lowercase()) {
            "usa" -> java.time.ZoneId.of("America/New_York")
            "gbr", "uk" -> java.time.ZoneId.of("Europe/London")
            "jpn" -> java.time.ZoneId.of("Asia/Tokyo")
            "kor" -> java.time.ZoneId.of("Asia/Seoul")
            "tha" -> java.time.ZoneId.of("Asia/Bangkok")
            "chn" -> java.time.ZoneId.of("Asia/Shanghai")
            "ind" -> java.time.ZoneId.of("Asia/Kolkata")
            "can" -> java.time.ZoneId.of("America/Toronto")
            "aus" -> java.time.ZoneId.of("Australia/Sydney")
            "fra" -> java.time.ZoneId.of("Europe/Paris")
            "deu", "ger" -> java.time.ZoneId.of("Europe/Berlin")
            "ita" -> java.time.ZoneId.of("Europe/Rome")
            "esp", "spa" -> java.time.ZoneId.of("Europe/Madrid")
            "bra" -> java.time.ZoneId.of("America/Sao_Paulo")
            "mex" -> java.time.ZoneId.of("America/Mexico_City")
            else -> {
                // Try to find a match or fallback to UTC if not found
                try {
                    // If it's a valid 2-letter ISO code, we might be able to map it,
                    // but TVDB often uses 3-letter. Fallback to UTC for unknown origins.
                    java.time.ZoneId.of("UTC")
                } catch (e: Exception) {
                    java.time.ZoneId.of("America/New_York")
                }
            }
        }
    }

    /** 
     * Helper to find the "next" or "latest" episode accurately based on today.
     */
    fun findLatestOrNextEpisode(episodes: List<org.knp.bingeboard.data.model.TvdbEpisode>?): org.knp.bingeboard.data.model.TvdbEpisode? {
        if (episodes.isNullOrEmpty()) return null
        
        val todayStr = LocalDate.now().toString()
        val validEpisodes = episodes.filter { !it.aired.isNullOrBlank() }
            .sortedBy { it.aired }
            
        if (validEpisodes.isEmpty()) return null

        val nextEpIndex = validEpisodes.indexOfFirst { it.aired!! >= todayStr }
        
        return if (nextEpIndex != -1) {
             validEpisodes[nextEpIndex]
        } else {
             validEpisodes.last()
        }
    }

    companion object {
        /** ISO 639-1 (2-letter) → ISO 639-2/B (3-letter) used by TVDB */
        private val LANGUAGE_MAP = mapOf(
            "en" to "eng",
            "hi" to "hin",
            "ta" to "tam",
            "te" to "tel",
            "ml" to "mal",
            "kn" to "kan",
            "bn" to "ben",
            "mr" to "mar",
            "es" to "spa",
            "fr" to "fra",
            "de" to "deu",
            "it" to "ita",
            "pt" to "por",
            "ja" to "jpn",
            "ko" to "kor",
            "zh" to "zho",
            "ru" to "rus",
            "ar" to "ara",
            "nl" to "nld",
            "sv" to "swe",
            "no" to "nor",
            "da" to "dan",
            "fi" to "fin",
            "th" to "tha",
            "id" to "ind",
            "ms" to "msa",
            "vi" to "vie",
            "tl" to "tgl",
            "tr" to "tur"
        )
    }
}
