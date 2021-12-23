package com.lycoon.clashapi.models.clan

import kotlinx.serialization.Serializable

@Serializable
data class ClanVersusRankingList(val items: List<ClanVersusRanking>)