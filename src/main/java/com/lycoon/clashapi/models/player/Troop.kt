package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.player.enums.Village
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Troop
(
    val level: Int,
    val name: String,
    val maxLevel: Int,
    val village: Village,

    @SerialName("superTroopIsActive")
    val isSuperTroopActive: Boolean? = false
)