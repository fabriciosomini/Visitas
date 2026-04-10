package com.msmobile.visitas.ui.views

import androidx.annotation.VisibleForTesting
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@VisibleForTesting
internal class DateTimePickerPreviewConfigProvider : PreviewParameterProvider<DateTimePickerPreviewConfig> {

    private val previewConfigLight = sequenceOf(
        DateTimePickerPreviewConfig(
            configName = "Date Tab",
            selectedTabIndex = 0,
            isDarkMode = false
        ),
        DateTimePickerPreviewConfig(
            configName = "Time Tab",
            selectedTabIndex = 1,
            isDarkMode = false
        )
    )

    private val previewConfigDark = previewConfigLight.map { config ->
        config.copy(
            configName = "${config.configName} - Dark Mode",
            isDarkMode = true
        )
    }

    override val values: Sequence<DateTimePickerPreviewConfig> = previewConfigLight + previewConfigDark

    override fun getDisplayName(index: Int): String {
        return values.elementAt(index).configName
    }
}

@VisibleForTesting
internal data class DateTimePickerPreviewConfig(
    val configName: String,
    val selectedTabIndex: Int,
    val isDarkMode: Boolean
)

