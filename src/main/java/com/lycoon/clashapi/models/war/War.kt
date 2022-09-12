package com.lycoon.clashapi.models.war

import kotlinx.serialization.Serializable

@Serializable
data class War(
    val clan: WarClan? = null, // if warTag from warleague is #0 (not found)
    val teamSize: Int = 0, // if clan is not in war
    val attacksPerMember: Int = 0, // if from a warleague round war
    val opponent: WarClan? = null, // if warTag from warleague is #0 (not found)
    val startTime: String? = null, // if warTag from warleague is #0 (not found)
    val state: String? = null,
    val endTime: String? = null, // if warTag from warleague is #0 (not found)
    val preparationStartTime: String? = null // if warTag from warleague is #0 (not found)
)