package com.lycoon.clashapi.core.interfaces

import com.lycoon.clashapi.core.exceptions.ClashAPIException
import com.lycoon.clashapi.models.player.Player
import java.io.IOException

interface IPlayerAPI
{
    /**
     * Returns the player attached to the tag.
     *
     * @param playerTag `String` of the player's tag
     * @return Player
     * @see Player
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayer(playerTag: String): Player

    /**
     * Returns whether the given player tag is verified or not.
     *
     * @param playerTag `String` of the player's tag
     * @param token `String` of the player token
     * @return a boolean
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun isVerifiedPlayer(playerTag: String, token: String): Boolean
}