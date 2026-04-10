package com.msmobile.visitas.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.tools.screenshot.PreviewTest

class RestoreBackupDialogScreenshotTest {

    @PreviewTest
    @Preview
    @Composable
    internal fun RestoreBackupDialogPreviewTest(
        @PreviewParameter(RestoreBackupDialogPreviewConfigProvider::class) config: RestoreBackupDialogPreviewConfig
    ) {
        RestoreBackupDialogPreview(config)
    }
}
