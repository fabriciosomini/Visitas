package com.msmobile.visitas

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.msmobile.visitas.ui.theme.VisitasTheme
import com.msmobile.visitas.util.IntentState
import com.ramcosta.composedestinations.generated.destinations.VisitListScreenDestination

class AppScaffoldScreenshotTest {

    @PreviewTest
    @Preview
    @Composable
    fun previewAppScaffold() {
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
                currentDestination = VisitListScreenDestination,
                onEvent = {},
                onNavigateToTab = {},
                onNavigate = {}
            ) {}
        }
    }
}
