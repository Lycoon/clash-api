package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class War(
    val clan: WarClan,
    val opponent: WarClan,
    val startTime: String,
    val state: String,
    val endTime: String,
    val preparationStartTime: String
)