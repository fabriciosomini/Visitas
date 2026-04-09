package com.msmobile.visitas.conversation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewScreenshotTest
import com.msmobile.visitas.AppScaffold
import com.msmobile.visitas.ui.theme.VisitasTheme
import com.ramcosta.composedestinations.generated.destinations.VisitDetailScreenDestination

class ConversationDetailScreenshotTest {

    @PreviewScreenshotTest
    @Preview
    @Composable
    fun conversationDetailScreenPreview(
        @PreviewParameter(ConversationDetailPreviewConfigProvider::class) config: ConversationDetailPreviewConfig
    ) {
        VisitasTheme(dynamicColor = false) {
            AppScaffold(
                uiState = config.mainActivityUiState,
                currentDestination = VisitDetailScreenDestination,
                onEvent = {},
                onNavigateToTab = {},
                onNavigate = {}
            ) {}
        }
    }
}
