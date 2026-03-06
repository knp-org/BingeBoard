package org.knp.bingeboard.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Represents a single option in a locale dropdown (region, language, or timezone).
 * Maps directly to the JSON structure in the assets folder.
 */
@JsonClass(generateAdapter = true)
data class LocaleOption(
    @Json(name = "code") val code: String,
    @Json(name = "name") val name: String
)
