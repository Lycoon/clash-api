package com.lycoon.clashapi.models.common

import kotlinx.serialization.Serializable

@Serializable
data class Label(val name: String? = null, val id: Int = 0, val iconUrls: IconUrls? = null)