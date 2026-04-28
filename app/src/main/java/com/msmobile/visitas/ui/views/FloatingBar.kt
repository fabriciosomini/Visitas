package com.msmobile.visitas.ui.views

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingToolbarDefaults.ScreenOffset
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FloatingBar(
    modifier: Modifier = Modifier,
    floatingActionButton: @Composable () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    HorizontalFloatingToolbar(
        modifier = modifier.offset(y = -ScreenOffset),
        expanded = true,
        floatingActionButton = floatingActionButton,
        content = content
    )
}