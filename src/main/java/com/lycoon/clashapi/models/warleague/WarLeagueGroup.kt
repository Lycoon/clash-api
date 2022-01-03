package com.lycoon.clashapi.models.warleague

import kotlinx.serialization.Serializable

@Serializable
data class WarLeagueGroup(
    val tag: String? = null, // always null?
    val state: String,
    val season: String,
    val clans: List<WarLeagueClan>,
    val rounds: List<WarLeagueRound>
)