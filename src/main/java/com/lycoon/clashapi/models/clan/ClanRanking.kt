package com.lycoon.clashapi.models.clan

import com.lycoon.clashapi.models.common.BadgeUrls
import com.lycoon.clashapi.models.common.Location
import kotlinx.serialization.Serializable

@Serializable
data class ClanRanking(
    val clanLevel: Int = 0,
    val clanPoints: Int = 0,
    val location: Location? = null,
    val members: Int = 0,
    val tag: String? = null,
    val name: String? = null,
    val rank: Int = 0,
    val previousRank: Int = 0,
    val badgeUrls: BadgeUrls? = null
)