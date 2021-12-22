package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.league.League
import kotlinx.serialization.Serializable

@Serializable
data class PlayerRanking(
    val clan: PlayerRankingClan,
    val league: League,
    val attackWins: Int,
    val defenseWins: Int,
    val tag: String,
    val name: String,
    val expLevel: Int,
    val rank: Int,
    val previousRank: Int,
    val trophies: Int
)