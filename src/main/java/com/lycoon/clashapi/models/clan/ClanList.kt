package com.lycoon.clashapi.models.clan

import kotlinx.serialization.Serializable

@Serializable
data class ClanList(val items: List<Clan>)