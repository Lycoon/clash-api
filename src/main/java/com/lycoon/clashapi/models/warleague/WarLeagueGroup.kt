package com.lycoon.clashapi.models.warleague

import kotlinx.serialization.Serializable

@Serializable
data class WarLeagueGroup(
    val tag: String? = null, // always null?
    val state: State? = null,
    val season: String? = null,
    val clans: List<WarLeagueClan>,
    val rounds: List<WarLeagueRound>
) {
    enum class State {GROUP_NOT_FOUND, NOT_IN_WAR, PREPARATION, WAR, ENDED}
}