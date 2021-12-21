package com.lycoon.clashapi.models.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Troop(
    val name: String,
    val level: Int,
    val maxLevel: Int,
    val village: String,
    @SerialName("superTroopIsActive") val isSuperTroopActive: Boolean? = false
)