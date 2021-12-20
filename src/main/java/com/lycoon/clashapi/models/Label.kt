package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Label(val name: String, val id: Int, val iconUrls: IconUrls)