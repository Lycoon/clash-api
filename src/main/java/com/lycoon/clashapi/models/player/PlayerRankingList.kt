package com.lycoon.clashapi.models.player

import kotlinx.serialization.Serializable

@Serializable
data class PlayerRankingList(val items: List<PlayerRanking>)