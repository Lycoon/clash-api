package com.lycoon.clashapi.models.war

import kotlinx.serialization.Serializable

@Serializable
data class War(
    val clan: WarClan?, // if warTag from warleague is #0 (not found)
    val teamSize: Int?, // if clan is not in war
    val attacksPerMember: Int?, // if from a warleague round war
    val opponent: WarClan?, // if warTag from warleague is #0 (not found)
    val startTime: String?, // if warTag from warleague is #0 (not found)
    val state: String,
    val endTime: String?, // if warTag from warleague is #0 (not found)
    val preparationStartTime: String? // if warTag from warleague is #0 (not found)
)