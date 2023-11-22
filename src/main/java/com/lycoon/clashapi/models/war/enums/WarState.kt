package com.lycoon.clashapi.models.war.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WarState
{
    @SerialName("clanNotFound") CLAN_NOT_FOUND,
    @SerialName("accessDenied") ACCESS_DENIED,
    @SerialName("notInWar") NOT_IN_WAR,
    @SerialName("inMatchmaking") IN_MATCHMAKING,
    @SerialName("enterWar") ENTER_WAR,
    @SerialName("matched") MATCHED,
    @SerialName("preparation") PREPARATION,
    @SerialName("war") WAR,
    @SerialName("inWar") IN_WAR,
    @SerialName("ended") ENDED
}