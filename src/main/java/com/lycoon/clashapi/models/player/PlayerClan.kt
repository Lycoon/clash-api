package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.common.BadgeUrls
import kotlinx.serialization.Serializable

@Serializable
data class PlayerClan(val tag: String? = null, val clanLevel: Int = 0, val name: String? = null, val badgeUrls: BadgeUrls? = null)