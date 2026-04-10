package com.msmobile.visitas.visit

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.tools.screenshot.PreviewTest

class VisitDetailScreenshotTest {

    @PreviewTest
    @Preview
    @Composable
    internal fun VisitDetailScreenPreviewTest(
        @PreviewParameter(VisitDetailPreviewConfigProvider::class) config: VisitDetailPreviewConfig
    ) {
        VisitDetailScreenPreview(config)
    }
}
