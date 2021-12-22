package com.lycoon.clashapi.models.clan

import kotlinx.serialization.Serializable

@Serializable
data class ClanVersusRanking(val clanVersusPoints: Int, val clanPoints: Int)