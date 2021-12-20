package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class ClanVersusRanking(val clanVersusPoints: Int, val clanPoints: Int)