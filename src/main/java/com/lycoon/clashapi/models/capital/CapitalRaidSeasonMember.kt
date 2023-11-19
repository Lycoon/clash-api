package com.lycoon.clashapi.models.capital

import kotlinx.serialization.Serializable

@Serializable
data class CapitalRaidSeasonMember(
    val tag: String? = null,
    val name: String? = null,
    val attacks: Int? = 0,
    val attackLimit: Int? = 0,
    val bonusAttackLimit: Int? = 0,
    val capitalResourcesLooted: Int? = 0
)