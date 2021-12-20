package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Language(val name: String, val id: Int, val languageCode: String)