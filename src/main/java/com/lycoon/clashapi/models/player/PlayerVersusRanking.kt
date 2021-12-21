package com.lycoon.clashapi.models.player

import kotlinx.serialization.Serializable

@Serializable
data class PlayerVersusRanking(
    val clan: PlayerRankingClan,
    val versusBattleWins: Int,
    val tag: String,
    val name: String,
    val expLevel: Int,
    val rank: Int,
    val previousRank: Int,
    val versusTrophies: Int
)