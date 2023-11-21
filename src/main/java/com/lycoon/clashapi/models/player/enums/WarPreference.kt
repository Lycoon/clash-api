package com.lycoon.clashapi.models.player.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WarPreference
{
    @SerialName("out") OUT,
    @SerialName("in") IN,
}