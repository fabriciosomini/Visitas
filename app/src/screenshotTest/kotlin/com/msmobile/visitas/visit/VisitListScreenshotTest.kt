package com.msmobile.visitas.visit

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.tools.screenshot.PreviewTest

class VisitListScreenshotTest {

    @PreviewTest
    @Preview
    @Composable
    internal fun VisitListScreenPreviewTest(
        @PreviewParameter(VisitListPreviewConfigProvider::class) config: VisitListPreviewConfig
    ) {
        VisitListScreenPreview(config)
    }
}
