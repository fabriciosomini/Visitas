package com.msmobile.visitas.conversation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.tools.screenshot.PreviewTest

class ConversationDetailScreenshotTest {

    @PreviewTest
    @Preview
    @Composable
    internal fun ConversationDetailScreenPreviewTest(
        @PreviewParameter(ConversationDetailPreviewConfigProvider::class) config: ConversationDetailPreviewConfig
    ) {
        ConversationDetailScreenPreview(config)
    }
}
