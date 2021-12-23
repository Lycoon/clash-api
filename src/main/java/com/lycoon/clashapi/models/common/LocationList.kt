package com.lycoon.clashapi.models.common

import kotlinx.serialization.Serializable

@Serializable
data class LocationList(val items: List<Location>)