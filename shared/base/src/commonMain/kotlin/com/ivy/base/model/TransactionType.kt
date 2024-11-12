package com.ivy.base.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
enum class TransactionType {
    INCOME, EXPENSE, TRANSFER
}
