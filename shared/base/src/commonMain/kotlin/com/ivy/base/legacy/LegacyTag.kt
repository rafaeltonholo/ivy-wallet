package com.ivy.base.legacy

import androidx.compose.runtime.Immutable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Immutable
@Deprecated("Use Tag Data Model")
@Suppress("DataClassTypedIDs")
@OptIn(ExperimentalUuidApi::class)
data class LegacyTag(val id: Uuid, val name: String)
