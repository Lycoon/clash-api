package com.lycoon.clashapi.models.player.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Village
{
    @SerialName("home") HOME_VILLAGE,
    @SerialName("builderBase") BUILDER_BASE,
    @SerialName("clanCapital") CLAN_CAPITAL
}