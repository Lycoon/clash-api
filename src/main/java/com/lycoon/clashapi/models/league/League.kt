package com.lycoon.clashapi.models.league

import com.lycoon.clashapi.models.common.IconUrls
import kotlinx.serialization.Serializable

@Serializable
data class League(val name: String? = null, val id: Int = 0, val iconUrls: IconUrls? = null)