package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.league.League
import kotlinx.serialization.Serializable

@Serializable
data class PlayerRanking(
    val clan: PlayerRankingClan? = null,
    val league: League? = null,
    val attackWins: Int = 0,
    val defenseWins: Int = 0,
    val tag: String? = null,
    val name: String? = null,
    val expLevel: Int = 0,
    val rank: Int = 0,
    val previousRank: Int = 0,
    val trophies: Int = 0
)