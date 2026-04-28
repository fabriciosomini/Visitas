package com.msmobile.visitas.ui.views

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingToolbarDefaults
import androidx.compose.material3.FloatingToolbarDefaults.ScreenOffset
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.lerp

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
        colors = FloatingToolbarDefaults.standardFloatingToolbarColors(
            toolbarContainerColor = lerp(
                MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f),
                0.2f
            )
        ),
        floatingActionButton = floatingActionButton,
        expandedShadowElevation = FloatingToolbarDefaults.ContainerExpandedElevationWithFab * 3,
        content = content
    )
}