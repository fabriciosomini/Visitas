package com.msmobile.visitas.conversation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.tools.screenshot.PreviewTest

class ConversationListScreenshotTest {
    @PreviewTest
    @Preview
    @Composable
    internal fun ConversationListScreenPreviewTest(
        @PreviewParameter(PreviewConfigProvider::class) config: PreviewConfig
    ) {
        ConversationListScreenPreview(config)
    }
}