package com.lycoon.clashapi.models.player

import kotlinx.serialization.Serializable

@Serializable
data class PlayerHouseElement(
    val id: Int? = 0,
    val type: Type
) {
    enum class Type{ GROUND, ROOF, FOOT, DECO }
}