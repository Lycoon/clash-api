package com.lycoon.clashapi.core.auth

/**
 * A list of tokens that can be cycled through.
 * - Constructed directly if ClashAPI is provided a token or list of tokens.
 * - Constructed indirectly through a KeyManager if ClashAPI is provided classic credentials.
 */
class TokenList
{
    constructor() : this(listOf())
    constructor(token: String) : this(listOf(token))
    constructor(tokens: List<String>) { array = tokens }

    private var array: List<String>
    private var index: Int = 0

    /**
     * Return current token and cycle to next one
     */
    fun get(): String {
        val token = array[index]
        if (++index >= array.size) index = 0

        return token;
    }

    fun size(): Int { return array.size }
    fun add(token: String) { array += token }
    fun remove(token: String) { array -= token }
}