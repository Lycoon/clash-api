package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class ClanWarAttack(
    val order: Int,
    val attackerTag: String,
    val defenderTag: String,
    val stars: Int,
    val destructionPercentage: Float,
    val duration: Int
)