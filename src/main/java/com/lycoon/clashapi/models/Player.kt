package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val clan: PlayerClan,
    val league: League,
    val role: String,
    val attackWins: Int,
    val defenseWins: Int,
    val townHallLevel: Int,
    val townHallWeaponLevel: Int,
    val versusBattleWins: Int,
    val legendStatistics: PlayerLegendStatistics,
    val troops: List<Troop>,
    val heroes: List<Troop>,
    val spells: List<Troop>,
    val labels: List<Label>,
    val tag: String,
    val name: String,
    val expLevel: Int,
    val trophies: Int,
    val bestTrophies: Int,
    val donations: Int,
    val donationsReceived: Int,
    val builderHallLevel: Int,
    val versusTrophies: Int,
    val bestVersusTrophies: Int,
    val warStars: Int,
    val achievements: List<Achievement>,
    val versusBattleWinCount: Int
)