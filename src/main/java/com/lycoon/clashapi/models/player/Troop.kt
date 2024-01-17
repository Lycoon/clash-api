package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.player.enums.Village
import kotlinx.serialization.Serializable

@Serializable
data class Troop
(
    val level: Int,
    val name: String,
    val maxLevel: Int,
    val village: Village,
    val superTroopIsActive: Boolean = false,
    val equipment: List<Equipment> = emptyList(),
)