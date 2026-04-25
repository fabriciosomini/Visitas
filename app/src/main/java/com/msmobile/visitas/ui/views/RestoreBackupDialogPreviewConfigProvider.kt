package com.msmobile.visitas.ui.views

import androidx.annotation.VisibleForTesting
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@VisibleForTesting
internal class RestoreBackupDialogPreviewConfigProvider : PreviewParameterProvider<RestoreBackupDialogPreviewConfig> {
    override val values: Sequence<RestoreBackupDialogPreviewConfig> = sequenceOf(
        RestoreBackupDialogPreviewConfig(
            configName = "Default"
        )
    )

    override fun getDisplayName(index: Int): String {
        return values.elementAt(index).configName
    }
}

@VisibleForTesting
internal data class RestoreBackupDialogPreviewConfig(
    val configName: String
)

