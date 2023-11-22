package com.lycoon.clashapi.core.interfaces

import com.lycoon.clashapi.core.SimpleQueryParamsBuilder
import com.lycoon.clashapi.core.exceptions.ClashAPIException
import com.lycoon.clashapi.models.common.Label
import java.io.IOException

interface ILabelAPI
{
    /**
     * Returns player labels
     *
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<Label>
     * @see Label
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getPlayerLabels(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<Label>

    /**
     * Returns clan labels
     *
     * @param queryParamsBuilder (optional) `SimpleQueryParamsBuilder` to build the query parameters
     * @return List<Label>
     * @see Label
     *
     * @throws IOException if the deserialization failed
     * @throws ClashAPIException if the request to the game API failed
     */
    @Throws(IOException::class, ClashAPIException::class)
    fun getClanLabels(queryParamsBuilder: SimpleQueryParamsBuilder? = null): List<Label>
}