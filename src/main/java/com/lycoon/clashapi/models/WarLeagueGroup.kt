package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class WarLeagueGroup(
    val tag: String,
    val state: String,
    val season: String,
    val clans: List<WarLeagueClan>,
    val rounds: List<WarLeagueRound>
)