package com.lycoon.clashapi.models.clan

import kotlinx.serialization.Serializable

@Serializable
data class ClanMemberList(val items: List<ClanMember>)