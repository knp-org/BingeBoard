package org.knp.bingeboard.data.model

data class PersonDetails(
    val id: Int,
    val source: Source,
    val name: String,
    val imageUrl: String?,
    val birthday: String?,
    val deathday: String?,
    val gender: String?,
    val birthPlace: String?,
    val knownFor: List<PersonCredit> = emptyList()
)

data class PersonCredit(
    val showId: Int,
    val showName: String,
    val character: String?,
    val posterUrl: String?,
    val source: Source,
    val firstAired: String? = null       // "yyyy-MM-dd" for sorting by most recent
)
