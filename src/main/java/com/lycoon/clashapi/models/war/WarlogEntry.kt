package com.lycoon.clashapi.models.war

import kotlinx.serialization.Serializable

@Serializable
data class WarlogEntry(
    val clan: WarlogClan? = null,
    val teamSize: Int = 0,
    val attacksPerMember: Int? = 0,
    val opponent: WarlogClan? = null,
    val endTime: String? = null,
    val result: Result
) {
    enum class Result { LOSE, WIN, TIE }
}