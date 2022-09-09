package com.lycoon.clashapi.models.clan

import com.lycoon.clashapi.models.league.League
import kotlinx.serialization.Serializable

@Serializable
data class ClanMember(
    val league: League,
    val tag: String,
    val name: String,
    val role: String,
    val expLevel: Int = 0,
    val clanRank: Int = 0,
    val previousClanRank: Int = 0,
    val donations: Int = 0,
    val donationsReceived: Int = 0,
    val trophies: Int = 0,
    val versusTrophies: Int = 0
)