package com.msmobile.visitas.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenshotTest
import com.msmobile.visitas.ui.theme.VisitasTheme

class RestoreBackupDialogScreenshotTest {

    @PreviewScreenshotTest
    @Preview
    @Composable
    fun restoreBackupDialogPreview() {
        VisitasTheme(dynamicColor = false) {
            RestoreBackupDialog(
                onConfirm = {},
                onDismiss = {}
            )
        }
    }
}
