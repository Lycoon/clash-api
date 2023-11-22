package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.player.enums.PlayerHouseType
import kotlinx.serialization.Serializable

@Serializable
data class PlayerHouseElement
(
    val id: Int = 0,
    val type: PlayerHouseType? = null
)