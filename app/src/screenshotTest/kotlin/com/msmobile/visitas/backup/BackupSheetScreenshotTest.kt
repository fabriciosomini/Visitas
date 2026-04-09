package com.msmobile.visitas.backup

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenshotTest
import com.msmobile.visitas.AppScaffold
import com.msmobile.visitas.MainActivityViewModel
import com.msmobile.visitas.ui.theme.VisitasTheme
import com.msmobile.visitas.util.IntentState
import com.ramcosta.composedestinations.generated.destinations.VisitListScreenDestination

class BackupSheetScreenshotTest {

    @PreviewScreenshotTest
    @Preview
    @Composable
    fun backupScreenPreview() {
        VisitasTheme(dynamicColor = false) {
            AppScaffold(
                uiState = MainActivityViewModel.UiState(
                    scaffoldState = MainActivityViewModel.ScaffoldState(
                        showBottomBar = false,
                        showFAB = false
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
