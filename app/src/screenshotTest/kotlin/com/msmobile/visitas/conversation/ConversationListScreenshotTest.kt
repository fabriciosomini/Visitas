package com.msmobile.visitas.conversation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.msmobile.visitas.AppScaffold
import com.msmobile.visitas.MainActivityViewModel
import com.msmobile.visitas.ui.theme.VisitasTheme
import com.msmobile.visitas.util.IntentState
import com.ramcosta.composedestinations.generated.destinations.ConversationListScreenDestination

class ConversationListScreenshotTest {

    @PreviewTest
    @Preview
    @Composable
    fun conversationListScreenPreview() {
        VisitasTheme(dynamicColor = false) {
            AppScaffold(
                uiState = MainActivityViewModel.UiState(
                    scaffoldState = MainActivityViewModel.ScaffoldState(
                        showBottomBar = true,
                        showFAB = true
                    ),
                    eventState = MainActivityViewModel.UiEventState.Idle,
                    intentState = IntentState.None
                ),
                currentDestination = ConversationListScreenDestination,
                onEvent = {},
                onNavigateToTab = {},
                onNavigate = {}
            ) {}
        }
    }
}
