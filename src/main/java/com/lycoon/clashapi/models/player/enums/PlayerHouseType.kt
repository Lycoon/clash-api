package com.lycoon.clashapi.models.player.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PlayerHouseType
{
    @SerialName("ground") GROUND,
    @SerialName("roof") ROOF,
    @SerialName("foot") FOOT,
    @SerialName("deco") DECO
}