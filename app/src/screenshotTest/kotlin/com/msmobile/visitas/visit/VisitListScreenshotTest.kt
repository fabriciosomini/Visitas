package com.msmobile.visitas.visit

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.tools.screenshot.PreviewTest
import com.msmobile.visitas.AppScaffold
import com.msmobile.visitas.ui.theme.VisitasTheme
import com.ramcosta.composedestinations.generated.destinations.VisitListScreenDestination

class VisitListScreenshotTest {

    @PreviewTest
    @Preview
    @Composable
    fun visitListScreenPreview(
        @PreviewParameter(VisitListPreviewConfigProvider::class) config: VisitListPreviewConfig
    ) {
        VisitasTheme(dynamicColor = false) {
            AppScaffold(
                uiState = config.mainActivityUiState,
                currentDestination = VisitListScreenDestination,
                onEvent = {},
                onNavigateToTab = {},
                onNavigate = {}
            ) {}
        }
    }
}
