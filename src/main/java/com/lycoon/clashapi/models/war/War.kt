package com.lycoon.clashapi.models.war

import kotlinx.serialization.Serializable

@Serializable
data class War(
    val clan: WarClan,
    val teamSize: Int,
    val attacksPerMember: Int? = null, // if from a warleague round war
    val opponent: WarClan,
    val startTime: String,
    val state: String,
    val endTime: String,
    val preparationStartTime: String
)