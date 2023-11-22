package com.lycoon.clashapi.models.clan.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class InviteType
{
    @SerialName("open") OPEN,
    @SerialName("inviteOnly") INVITE_ONLY,
    @SerialName("closed") CLOSED
}