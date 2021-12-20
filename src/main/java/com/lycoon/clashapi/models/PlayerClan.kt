package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class PlayerClan(val tag: String, val clanLevel: Int, val name: String, val badgeUrls: BadgeUrls)