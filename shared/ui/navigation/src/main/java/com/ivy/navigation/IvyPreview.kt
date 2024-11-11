package com.ivy.navigation

import androidx.compose.runtime.Composable
import dev.tonholo.ivy.design.system.core.theme.IvyMaterial3Theme

@Composable
fun IvyPreview(
    dark: Boolean = false,
    content: @Composable () -> Unit,
) {
    NavigationRoot(navigation = Navigation()) {
        IvyMaterial3Theme(dark = dark, isTrueBlack = false, content = content)
    }
}
