package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class IconUrls(val tiny: String? = null, val small: String, val medium: String)