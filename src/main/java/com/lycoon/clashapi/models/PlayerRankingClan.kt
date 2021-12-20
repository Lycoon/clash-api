package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class PlayerRankingClan(val tag: String, val name: String, val badgeUrls: BadgeUrls)