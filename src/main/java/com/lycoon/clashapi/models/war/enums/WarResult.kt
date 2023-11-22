package com.lycoon.clashapi.models.war.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WarResult
{
    @SerialName("lose") LOSE,
    @SerialName("win") WIN,
    @SerialName("tie") TIE
}