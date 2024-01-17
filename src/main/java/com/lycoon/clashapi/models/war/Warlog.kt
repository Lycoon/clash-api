package com.lycoon.clashapi.models.war

import kotlinx.serialization.Serializable

@Serializable
data class Warlog
(
    val items: List<WarlogEntry>
)
