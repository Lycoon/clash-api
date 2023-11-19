package com.lycoon.clashapi.models.player

import kotlinx.serialization.Serializable

@Serializable
data class PlayerHouse(
    val elements: List<PlayerHouseElement>
)