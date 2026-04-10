package com.msmobile.visitas.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.msmobile.visitas.ui.theme.VisitasTheme

class RestoreBackupDialogScreenshotTest {

    @PreviewTest
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
