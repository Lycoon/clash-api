package com.lycoon.clashapi.models.player

import kotlinx.serialization.Serializable

@Serializable
data class PlayerVersusRanking(
    val clan: PlayerRankingClan? = null,
    val versusTrophies: Int = 0,
    val versusBattleWins: Int = 0,
    val tag: String? = null,
    val name: String? = null,
    val expLevel: Int = 0,
    val rank: Int = 0,
    val previousRank: Int = 0,
    val builderBaseTrophies: Int = 0
)