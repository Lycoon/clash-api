package com.lycoon.clashapi.models.capital

import kotlinx.serialization.Serializable

@Serializable
data class CapitalRaidSeasonAttack(
    val attacker: CapitalRaidSeasonAttacker,
    val destructionPercent: Int? = 0,
    val stars: Int? = 0
)