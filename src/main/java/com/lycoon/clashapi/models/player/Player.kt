package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.common.Label
import com.lycoon.clashapi.models.league.League
import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val clan: PlayerClan? = null,
    val league: League? = null,
    val role: String,
    var warPreference: String,
    val attackWins: Int,
    val defenseWins: Int,
    val townHallLevel: Int,
    val townHallWeaponLevel: Int = 0,
    val versusBattleWins: Int = 0,
    val legendStatistics: PlayerLegendStatistics? = null,
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
    val builderHallLevel: Int = 0,
    val versusTrophies: Int = 0,
    val bestVersusTrophies: Int = 0,
    val warStars: Int,
    val achievements: List<Achievement>,
    val versusBattleWinCount: Int = 0
)