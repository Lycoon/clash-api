package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.common.BadgeUrls
import kotlinx.serialization.Serializable

@Serializable
data class PlayerClan
(
    val tag: String,
    val clanLevel: Int,
    val name: String,
    val badgeUrls: BadgeUrls? = null
)