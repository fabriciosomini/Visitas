package com.msmobile.visitas.ui.views

import androidx.annotation.VisibleForTesting
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@VisibleForTesting
internal class RestoreBackupDialogPreviewConfigProvider : PreviewParameterProvider<RestoreBackupDialogPreviewConfig> {

    private val previewConfigLight = sequenceOf(
        RestoreBackupDialogPreviewConfig(
            configName = "Default",
            isDarkMode = false
        )
    )

    private val previewConfigDark = previewConfigLight.map { config ->
        config.copy(
            configName = "${config.configName} - Dark Mode",
            isDarkMode = true
        )
    }

    override val values: Sequence<RestoreBackupDialogPreviewConfig> = previewConfigLight + previewConfigDark

    override fun getDisplayName(index: Int): String {
        return values.elementAt(index).configName
    }
}

@VisibleForTesting
internal data class RestoreBackupDialogPreviewConfig(
    val configName: String,
    val isDarkMode: Boolean
)

