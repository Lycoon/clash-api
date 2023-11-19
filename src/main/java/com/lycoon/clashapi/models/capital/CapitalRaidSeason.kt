package com.lycoon.clashapi.models.capital

import kotlinx.serialization.Serializable

@Serializable
data class CapitalRaidSeason(
    val attackLog: List<CapitalRaidSeasonAttackLog>,
    val defenseLog: List<CapitalRaidSeasonDefenseLog>,
    val state: String? = null,
    val startTime: String? = null,
    val endTime: String? = null,
    val capitalTotalLoot: Int? = 0,
    val raidsCompleted: Int? = 0,
    val totalAttacks: Int? = 0,
    val enemyDistrictsDestroyed: Int? = 0,
    val offensiveReward: Int? = 0,
    val defensiveReward: Int? = 0,
    val members: List<CapitalRaidSeasonMember>
)