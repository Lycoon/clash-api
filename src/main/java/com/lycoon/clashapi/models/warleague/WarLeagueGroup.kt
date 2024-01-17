package com.lycoon.clashapi.models.warleague

import com.lycoon.clashapi.models.warleague.enums.WarLeagueGroupState
import kotlinx.serialization.Serializable

@Serializable
data class WarLeagueGroup
(
    val tag: String? = null, // always null?
    val state: WarLeagueGroupState,
    val season: String? = null,
    val clans: List<WarLeagueClan>,
    val rounds: List<WarLeagueRound>
)