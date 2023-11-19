package com.lycoon.clashapi.models.capital

import com.lycoon.clashapi.models.common.BadgeUrls
import kotlinx.serialization.Serializable

@Serializable
data class CapitalRaidSeasonClanInfo(
    val tag: String? = null,
    val name: String? = null,
    val level: Int? = 0,
    val badgeUrls: BadgeUrls? = null
)