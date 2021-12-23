package com.lycoon.clashapi.models.war

import com.lycoon.clashapi.models.common.BadgeUrls
import kotlinx.serialization.Serializable

@Serializable
data class WarlogClan(
    val destructionPercentage: Float,
    val tag: String? = null, // if warleague result
    val name: String? = null, // if warleague result
    val badgeUrls: BadgeUrls,
    val clanLevel: Int,
    val attacks: Int? = null, // if warleague result or opponent in warlog clan
    val stars: Int,
    val expEarned: Int? = null // if warleague result or opponent in warlog clan
)