package com.lycoon.clashapi.models.war

import kotlinx.serialization.Serializable

@Serializable
data class War(
    val clan: WarClan? = null, // if warTag from warleague is #0 (not found)
    val teamSize: Int = 0, // if clan is not in war
    val attacksPerMember: Int = 0, // if from a warleague round war
    val opponent: WarClan? = null, // if warTag from warleague is #0 (not found)
    val startTime: String? = null, // if warTag from warleague is #0 (not found)
    val state: State,
    val endTime: String? = null, // if warTag from warleague is #0 (not found)
    val preparationStartTime: String? = null // if warTag from warleague is #0 (not found)
) {
    enum class State {
        CLAN_NOT_FOUND, ACCESS_DENIED, NOT_IN_WAR,
        IN_MATCHMAKING, ENTER_WAR, MATCHED, PREPARATION,
        WAR, IN_WAR, ENDED
    }
}