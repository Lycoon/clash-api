package com.lycoon.clashapi.core.interfaces

import com.lycoon.clashapi.core.exceptions.ClashAPIException
import com.lycoon.clashapi.models.common.GoldPassSeason
import java.io.IOException

interface IGoldPassAPI
{
    /**
     * Returns gold pass information
     *
     * @return GoldPassSeason
     * @see GoldPassSeason
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getGoldPass(): GoldPassSeason
}