package com.lycoon.clashapi.models.warleague

import kotlinx.serialization.Serializable

@Serializable
data class WarLeagueMember(val tag: String? = null, val townHallLevel: Int = 0, val name: String? = null)