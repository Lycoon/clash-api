package com.lycoon.clashapi.models.common

import kotlinx.serialization.Serializable

@Serializable
data class LabelList(val items: List<Label>)