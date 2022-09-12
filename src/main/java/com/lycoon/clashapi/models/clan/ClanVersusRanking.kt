package com.lycoon.clashapi.models.clan

import kotlinx.serialization.Serializable

@Serializable
data class ClanVersusRanking(val clanVersusPoints: Int = 0, val clanPoints: Int = 0)