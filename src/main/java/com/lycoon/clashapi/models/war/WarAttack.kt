package com.lycoon.clashapi.models.war

import kotlinx.serialization.Serializable

@Serializable
data class WarAttack
(
    val order: Int = 0,
    val attackerTag: String? = null,
    val defenderTag: String? = null,
    val stars: Int = 0,
    val destructionPercentage: Float = 0f,
    val duration: Int = 0
)