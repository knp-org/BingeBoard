package org.knp.bingeboard.data.repository

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.knp.bingeboard.data.model.LocaleOption
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Provides locale options (regions, languages, timezones) loaded from JSON asset files.
 * This data is shared across all screens that need locale filtering.
 */
@Singleton
class LocaleOptionsProvider @Inject constructor(
    private val context: Context,
    private val moshi: Moshi
) {
    private val listType = Types.newParameterizedType(List::class.java, LocaleOption::class.java)
    private val adapter = moshi.adapter<List<LocaleOption>>(listType)

    val regions: List<LocaleOption> by lazy { loadFromAssets("regions.json") }
    val languages: List<LocaleOption> by lazy { loadFromAssets("languages.json") }
    val timezones: List<LocaleOption> by lazy { loadFromAssets("timezones.json") }

    private fun loadFromAssets(fileName: String): List<LocaleOption> {
        return try {
            val json = context.assets.open(fileName).bufferedReader().use { it.readText() }
            adapter.fromJson(json) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
