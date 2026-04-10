package com.msmobile.visitas

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.tools.screenshot.PreviewTest

class AppScaffoldScreenshotTest {

    @PreviewTest
    @Preview
    @Composable
    internal fun AppScaffoldPreviewTest(
        @PreviewParameter(AppScaffoldPreviewConfigProvider::class) config: AppScaffoldPreviewConfig
    ) {
        AppScaffoldPreview(config)
    }
}
