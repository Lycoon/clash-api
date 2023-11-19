package com.lycoon.clashapi.models.clan

import kotlinx.serialization.Serializable

@Serializable
data class ClanVersusRanking(
    val clanPoints: Int = 0,
    val clanBuilderBasePoints: Int = 0,
    val clanVersusPoints: Int = 0
)