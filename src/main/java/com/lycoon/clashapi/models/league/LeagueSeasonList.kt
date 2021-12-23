package com.lycoon.clashapi.models.league

import kotlinx.serialization.Serializable

@Serializable
data class LeagueSeasonList(val items: List<LeagueSeason>)