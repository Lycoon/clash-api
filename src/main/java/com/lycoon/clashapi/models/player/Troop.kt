package com.lycoon.clashapi.models.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Troop(
    val name: String? = null,
    val level: Int = 0,
    val maxLevel: Int = 0,
    val village: String? = null,
    @SerialName("superTroopIsActive") val isSuperTroopActive: Boolean? = false
)