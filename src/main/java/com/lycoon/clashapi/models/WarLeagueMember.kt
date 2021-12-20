package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class WarLeagueMember(val tag: String, val townHallLevel: Int, val name: String)