package com.ivy.base.resource

import androidx.annotation.StringRes

// TODO: Add unit tests for this class
class TestResourceProvider : ResourceProvider<Int> {
    private val strings = mutableMapOf<Int, String>()

    fun putString(@StringRes resId: Int, value: String) {
        strings[resId] = value
    }

    override fun getString(@StringRes resource: Int): String {
        return strings[resource] ?: stringNotFoundError(resource)
    }

    override fun getString(@StringRes resource: Int, vararg args: Any): String {
        // TODO: this function might not work, add unit tests to verify correctness
        return strings[resource]?.let { String.format(it, *args) }
            ?: stringNotFoundError(resource)
    }

    private fun stringNotFoundError(@StringRes resId: Int): Nothing =
        throw TestStringNotFoundException(resId)
}

class TestStringNotFoundException(@StringRes val stringRes: Int) :
    IllegalStateException("TestResourceProvider(): String not found for resId=$stringRes")
