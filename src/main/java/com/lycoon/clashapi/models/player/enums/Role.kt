package com.lycoon.clashapi.models.player.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Role
{
    @SerialName("notMember") NOT_MEMBER,
    @SerialName("member") MEMBER,
    @SerialName("leader") LEADER,
    @SerialName("admin") ADMIN,
    @SerialName("coLeader") COLEADER
}
