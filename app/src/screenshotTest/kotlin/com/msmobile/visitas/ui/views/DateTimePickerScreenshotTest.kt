package com.msmobile.visitas.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.tools.screenshot.PreviewTest

class DateTimePickerScreenshotTest {

    @PreviewTest
    @Preview
    @Composable
    internal fun DateTimePickerPreviewTest(
        @PreviewParameter(PreviewConfigProvider::class) config: PreviewConfig
    ) {
        DateTimePickerPreview(config)
    }
}
