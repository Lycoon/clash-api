package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class ClanMember(
    val league: League,
    val tag: String,
    val name: String,
    val role: String,
    val expLevel: Int,
    val clanRank: Int,
    val previousClanRank: Int,
    val donations: Int,
    val donationsReceived: Int,
    val trophies: Int,
    val versusTrophies: Int
)