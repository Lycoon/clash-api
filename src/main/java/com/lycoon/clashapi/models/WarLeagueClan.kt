package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class WarLeagueClan(
    val tag: String,
    val clanLevel: Int,
    val name: String,
    val members: List<WarLeagueMember>,
    val badgeUrls: BadgeUrls
)