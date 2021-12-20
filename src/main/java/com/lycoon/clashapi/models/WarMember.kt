package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class WarMember(
    val tag: String,
    val name: String,
    val mapPosition: Int,
    val townhallLevel: Int,
    val opponentAttack: Int,
    val bestOpponentAttack: WarAttack,
    val attacks: List<WarAttack>
)