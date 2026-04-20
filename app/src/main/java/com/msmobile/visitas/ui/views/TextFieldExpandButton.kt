package com.msmobile.visitas.ui.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.msmobile.visitas.R

@Composable
fun TextFieldExpandButton(show: Boolean, isExpanded: Boolean, onExpand: () -> Unit) {
    val contentDescription = if (isExpanded) {
        stringResource(id = R.string.collapse_text_content_description)
    } else {
        stringResource(id = R.string.expand_text_content_description)
    }
    val icon = if (isExpanded) {
        Icons.Outlined.ExpandLess
    } else {
        Icons.Outlined.ExpandMore
    }
    AnimatedVisibility(visible = show) {
        IconButton(
            onClick = onExpand
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription
            )
        }
    }
}