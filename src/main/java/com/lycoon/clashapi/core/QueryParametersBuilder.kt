package com.lycoon.clashapi.core

abstract class QueryBuilder()
{
    fun build() {}

    private fun setLimit(limit: Int) { this.limit = limit; }
    private fun setAfter(after: String) { this.after = after; }
    private fun setBefore(before: String) { this.before = before; }

    protected var limit: Int = 0;
    protected var after: String = "";
    protected var before: String = "";
}

abstract class WarlogQueryBuilder(): QueryBuilder()
{
    abstract fun setLimit(limit: Int);
    fun setAfter(after: String) { this.after = after; }
    fun setBefore(before: String) { this.before = before; }
}
