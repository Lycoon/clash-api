package com.lycoon.clashapi.models.war

import kotlinx.serialization.Serializable

@Serializable
data class WarMember(
    val tag: String? = null,
    val name: String? = null,
    val mapPosition: Int = 0,
    val townhallLevel: Int = 0,
    val opponentAttack: Int = 0,
    val bestOpponentAttack: WarAttack? = null,
    val attacks: List<WarAttack>? = emptyList()
)