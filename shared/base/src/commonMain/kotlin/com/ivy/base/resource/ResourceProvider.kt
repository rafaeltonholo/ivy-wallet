package com.ivy.base.resource

/**
 * @param TResourceType a generic type to support the difference between
 * Android's Resource (@String Int) and KMP's Resource (StringResource).
 */
interface ResourceProvider<TResourceType> {
    fun getString(resource: TResourceType): String
    fun getString(resource: TResourceType, vararg args: Any): String
}
