package com.lycoon.clashapi.models.league

import kotlinx.serialization.Serializable

@Serializable
data class LeagueList(val items: List<League>)