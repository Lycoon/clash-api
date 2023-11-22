package com.lycoon.clashapi.models.war

import com.lycoon.clashapi.models.common.BadgeUrls
import kotlinx.serialization.Serializable

@Serializable
data class WarClan
(
    val destructionPercentage: Float = 0f,
    val tag: String? = null,                        // if clan is not in war
    val name: String? = null,                       // if clan is not in war
    val badgeUrls: BadgeUrls? = null,
    val clanLevel: Int = 0,
    val attacks: Int = 0,
    val stars: Int = 0,
    val expEarned: Int = 0,                         // if from a war league round war
    val members: List<WarMember> = emptyList(),     // if clan is not in war
)