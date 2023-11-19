package com.lycoon.clashapi.models.common

import kotlinx.serialization.Serializable

@Serializable
data class Language(
    val name: String? = null,
    val id: Int = 0,
    val languageCode: String? = null
)