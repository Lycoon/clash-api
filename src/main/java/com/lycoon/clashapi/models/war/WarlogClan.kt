package com.lycoon.clashapi.models.war

import com.lycoon.clashapi.models.common.BadgeUrls
import kotlinx.serialization.Serializable

@Serializable
data class WarlogClan(
    val destructionPercentage: Float = 0f,
    val tag: String? = null, // if warleague result
    val name: String? = null, // if warleague result
    val badgeUrls: BadgeUrls? = null,
    val clanLevel: Int = 0,
    val attacks: Int = 0, // if warleague result or opponent in warlog clan
    val stars: Int = 0,
    val expEarned: Int = 0, // if warleague result or opponent in warlog clan
    val members: List<WarMember>
)