package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.common.Label
import com.lycoon.clashapi.models.league.BuilderBaseLeague
import com.lycoon.clashapi.models.league.League
import com.lycoon.clashapi.models.player.enums.Role
import com.lycoon.clashapi.models.player.enums.WarPreference
import kotlinx.serialization.Serializable

typealias Spell = Troop
typealias Hero = Troop

@Serializable
data class Player
(
    val tag: String,
    val name: String,
    val playerHouse: PlayerHouse? = null,        // nullable if not in clan
    val clan: PlayerClan? = null,                // nullable if not in clan
    val role: Role? = null,                      // nullable if not in clan
    val expLevel: Int = 0,
    val trophies: Int = 0,
    val builderHallLevel: Int = 0,
    val townHallWeaponLevel: Int = 0,
    val townHallLevel: Int = 0,
    val warPreference: WarPreference? = null,    // nullable if not in clan
    val warStars: Int = 0,
    val achievements: List<Achievement>,
    val labels: List<Label>,
    val clanCapitalContributions: Int = 0,

    val builderBaseLeague: BuilderBaseLeague? = null,
    val league: League? = null,
    val legendStatistics: PlayerLegendStatistics? = null,

    val troops: List<Troop>,
    val heroes: List<Hero>,
    val spells: List<Spell>,

    val bestTrophies: Int = 0,
    val builderBaseTrophies: Int = 0,
    val bestBuilderBaseTrophies: Int = 0,
    val versusTrophies: Int = 0,
    val bestVersusTrophies: Int = 0,

    val attackWins: Int = 0,
    val defenseWins: Int = 0,
    val versusBattleWins: Int = 0,
    val donations: Int = 0,
    val donationsReceived: Int = 0,
)