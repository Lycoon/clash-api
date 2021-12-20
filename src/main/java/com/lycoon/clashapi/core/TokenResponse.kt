package com.lycoon.clashapi.core

import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(val tag: String, val token: String, val status: String)
