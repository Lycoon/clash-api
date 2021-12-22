package com.lycoon.clashapi.models.warleague

import com.lycoon.clashapi.models.common.BadgeUrls
import kotlinx.serialization.Serializable

@Serializable
data class WarLeagueClan(
    val tag: String,
    val clanLevel: Int,
    val name: String,
    val members: List<WarLeagueMember>,
    val badgeUrls: BadgeUrls
)