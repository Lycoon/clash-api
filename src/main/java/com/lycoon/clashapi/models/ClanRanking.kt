package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class ClanRanking(
    val clanLevel: Int,
    val clanPoints: Int,
    val location: Location,
    val members: Int,
    val tag: String,
    val name: String,
    val rank: Int,
    val previousRank: Int,
    val badgeUrls: BadgeUrls
)