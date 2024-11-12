package com.ivy.base.resource

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@Suppress("UnnecessaryPassThroughClass")
class AndroidResourceProvider @Inject constructor(
    @ApplicationContext
    private val context: Context,
) : ResourceProvider<Int> {
    override fun getString(@StringRes resource: Int): String = context.getString(resource)

    override fun getString(
        @StringRes resource: Int,
        vararg args: Any,
    ): String = context.getString(resource, args)
}
