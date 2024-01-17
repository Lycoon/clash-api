package com.lycoon.clashapi.models.warleague.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WarLeagueGroupState
{
    @SerialName("groupNotFound") GROUP_NOT_FOUND,
    @SerialName("notInWar") NOT_IN_WAR,
    @SerialName("preparation") PREPARATION,
    @SerialName("war") WAR,
    @SerialName("ended") ENDED
}