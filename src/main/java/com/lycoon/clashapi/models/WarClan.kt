package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class WarClan(
    val destructionPercentage: Float,
    val tag: String,
    val name: String,
    val badgeUrls: BadgeUrls,
    val clanLevel: Int,
    val attacks: Int,
    val stars: Int,
    val expEarned: Int,
    val members: List<WarMember>
)