package org.knp.bingeboard.ui.screens.person

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.knp.bingeboard.data.model.PersonCredit
import org.knp.bingeboard.data.model.PersonDetails
import org.knp.bingeboard.data.model.Source
import org.knp.bingeboard.data.repository.TvMazeRepository
import org.knp.bingeboard.data.repository.TvdbRepository
import org.knp.bingeboard.data.repository.UserPreferencesRepository
import javax.inject.Inject

data class PersonUiState(
    val person: PersonDetails? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)

@HiltViewModel
class PersonViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val tvMazeRepository: TvMazeRepository,
    private val tvdbRepository: TvdbRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PersonUiState())
    val uiState: StateFlow<PersonUiState> = _uiState.asStateFlow()

    private val personId: Int = savedStateHandle.get<Int>("personId") ?: 0
    private val source: String = savedStateHandle.get<String>("source") ?: "tvmaze"

    init {
        loadPerson()
    }

    private fun loadPerson() {
        viewModelScope.launch {
            _uiState.value = PersonUiState(isLoading = true)

            val person = when (source) {
                "tvdb" -> loadFromTvdb()
                else -> loadFromTvMaze()
            }

            _uiState.value = PersonUiState(
                person = person,
                isLoading = false,
                error = if (person == null) "Failed to load person details" else null
            )
        }
    }

    private suspend fun loadFromTvMaze(): PersonDetails? {
        val detailResult = tvMazeRepository.getPersonDetails(personId)
        val person = detailResult.getOrNull() ?: return null
        val credits = tvMazeRepository.getPersonCastCredits(personId).getOrNull() ?: emptyList()

        val lang = userPreferencesRepository.language.first()
        val tvdbLang = tvdbRepository.toTvdbLanguageCode(lang)

        val knownFor = coroutineScope {
            credits.mapNotNull { credit ->
                val show = credit.embedded?.show ?: return@mapNotNull null
                async {
                    val translatedName = show.externals?.thetvdb?.let { tvdbId ->
                        tvdbRepository.getSeriesTranslatedName(tvdbId, tvdbLang)
                    }

                    PersonCredit(
                        showId = show.id,
                        showName = translatedName ?: show.name,
                        character = credit.embedded.character?.name,
                        posterUrl = show.image?.medium ?: show.image?.original,
                        source = Source.TVMAZE,
                        firstAired = show.premiered
                    )
                }
            }.awaitAll()
        }
            .distinctBy { it.showId }
            .let { credits ->
                val hasAnyDate = credits.any { !it.firstAired.isNullOrBlank() }
                if (hasAnyDate) {
                    credits.sortedByDescending { it.firstAired ?: "" }
                } else {
                    credits.reversed()
                }
            }

        return PersonDetails(
            id = person.id,
            source = Source.TVMAZE,
            name = person.name,
            imageUrl = person.image?.original ?: person.image?.medium,
            birthday = person.birthday,
            deathday = person.deathday,
            gender = person.gender,
            birthPlace = person.country?.name,
            knownFor = knownFor
        )
    }

    private suspend fun loadFromTvdb(): PersonDetails? {
        val result = tvdbRepository.getPerson(personId)
        val person = result.getOrNull()?.data ?: return null

        val lang = userPreferencesRepository.language.first()
        val tvdbLang = tvdbRepository.toTvdbLanguageCode(lang)

        val rawCredits = person.characters
            ?.filter { it.seriesId != null }
            ?.distinctBy { it.seriesId }
            ?: emptyList()

        val knownFor = coroutineScope {
            rawCredits.map { char ->
                async {
                    val translatedName = tvdbRepository.getSeriesTranslatedName(char.seriesId!!, tvdbLang)

                    PersonCredit(
                        showId = char.seriesId!!,
                        showName = translatedName ?: char.series?.name ?: "",
                        character = char.name,
                        posterUrl = char.series?.image,
                        source = Source.TVDB,
                        firstAired = char.series?.firstAired
                    )
                }
            }.awaitAll()
        }.let { credits ->
            // Sort by most recent first; if no dates available, reverse API order (API returns oldest first)
            val hasAnyDate = credits.any { !it.firstAired.isNullOrBlank() }
            if (hasAnyDate) {
                credits.sortedByDescending { it.firstAired ?: "" }
            } else {
                credits.reversed()
            }
        }

        val genderStr = when (person.gender) {
            1 -> "Male"
            2 -> "Female"
            3 -> "Non-binary"
            else -> null
        }

        return PersonDetails(
            id = person.id,
            source = Source.TVDB,
            name = person.name ?: "Unknown",
            imageUrl = person.image,
            birthday = person.birth,
            deathday = person.death,
            gender = genderStr,
            birthPlace = person.birthPlace,
            knownFor = knownFor
        )
    }
}
