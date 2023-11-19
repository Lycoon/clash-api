package com.lycoon.clashapi.models.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Troop(
    val level: Int = 0,
    val name: String? = null,
    val maxLevel: Int = 0,
    val village: Player.VillageType,

    @SerialName("superTroopIsActive")
    val isSuperTroopActive: Boolean? = false
)