package com.lycoon.clashapi.models.war

import kotlinx.serialization.Serializable

@Serializable
data class WarMember(
    val tag: String,
    val name: String,
    val mapPosition: Int? = null,
    val townhallLevel: Int? = null,
    val opponentAttack: Int? = null,
    val bestOpponentAttack: WarAttack? = null,
    val attacks: List<WarAttack>? = null
)