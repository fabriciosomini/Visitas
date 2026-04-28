package com.msmobile.visitas.util

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingToolbarDefaults
import androidx.compose.ui.unit.dp

private val noDp = 0.dp
private val largeDp = 24.dp
private val mediumDp = largeDp / 2
private val smallDp = mediumDp / 2

val borderPadding = smallDp
val verticalFieldPadding = mediumDp
val horizontalFieldPadding = mediumDp
val cardInnerPadding = mediumDp
val cardHeight = 150.dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
val floatingBarBottomPadding = FloatingToolbarDefaults.ContainerSize
