package com.lycoon.clashapi.models.common

import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(val tag: String, val token: String, val status: String)
