package com.lycoon.clashapi.models.war

import com.lycoon.clashapi.models.war.enums.WarResult
import kotlinx.serialization.Serializable

@Serializable
data class WarlogEntry
(
    val clan: WarlogClan,
    val teamSize: Int = 0,
    val attacksPerMember: Int = 0,
    val opponent: WarlogClan? = null,
    val endTime: String? = null,
    val result: WarResult? = null,
)
