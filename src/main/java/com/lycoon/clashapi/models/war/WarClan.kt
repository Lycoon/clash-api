package com.lycoon.clashapi.models.war

import com.lycoon.clashapi.models.common.BadgeUrls
import kotlinx.serialization.Serializable

@Serializable
data class WarClan(
    val destructionPercentage: Float,
    val tag: String? = null, // if clan is not in war
    val name: String? = null, // if clan is not in war
    val badgeUrls: BadgeUrls,
    val clanLevel: Int,
    val attacks: Int,
    val stars: Int,
    val expEarned: Int? = null, // if from a warleague round war
    val members: List<WarMember>? = null, // if clan is not in war
)