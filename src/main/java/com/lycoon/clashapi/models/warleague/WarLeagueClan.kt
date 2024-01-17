package com.lycoon.clashapi.models.warleague

import com.lycoon.clashapi.models.common.BadgeUrls
import kotlinx.serialization.Serializable

@Serializable
data class WarLeagueClan
(
    val tag: String? = null,
    val clanLevel: Int = 0,
    val name: String? = null,
    val members: List<WarLeagueMember>,
    val badgeUrls: BadgeUrls? = null
)