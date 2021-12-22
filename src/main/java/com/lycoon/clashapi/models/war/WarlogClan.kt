package com.lycoon.clashapi.models.war

import com.lycoon.clashapi.models.common.BadgeUrls
import kotlinx.serialization.Serializable

@Serializable
data class WarlogClan(
    val destructionPercentage: Float,
    val tag: String,
    val name: String? = null,
    val badgeUrls: BadgeUrls,
    val clanLevel: Int,
    val attacks: Int,
    val stars: Int,
    val expEarned: Int
)