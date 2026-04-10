package com.msmobile.visitas

import androidx.annotation.VisibleForTesting
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.msmobile.visitas.util.IntentState
import com.ramcosta.composedestinations.generated.destinations.VisitListScreenDestination
import com.ramcosta.composedestinations.spec.DestinationSpec

@VisibleForTesting
internal class AppScaffoldPreviewConfigProvider : PreviewParameterProvider<AppScaffoldPreviewConfig> {

    private val previewConfigLight = sequenceOf(
        AppScaffoldPreviewConfig(
            configName = "With Bottom Bar and FAB",
            uiState = MainActivityViewModel.UiState(
                scaffoldState = MainActivityViewModel.ScaffoldState(
                    showBottomBar = true,
                    showFAB = true
                ),
                eventState = MainActivityViewModel.UiEventState.Idle,
                intentState = IntentState.None
            ),
            currentDestination = VisitListScreenDestination,
            isDarkMode = false
        ),
        AppScaffoldPreviewConfig(
            configName = "Without Bottom Bar and FAB",
            uiState = MainActivityViewModel.UiState(
                scaffoldState = MainActivityViewModel.ScaffoldState(
                    showBottomBar = false,
                    showFAB = false
                ),
                eventState = MainActivityViewModel.UiEventState.Idle,
                intentState = IntentState.None
            ),
            currentDestination = VisitListScreenDestination,
            isDarkMode = false
        )
    )

    private val previewConfigDark = previewConfigLight.map { config ->
        config.copy(
            configName = "${config.configName} - Dark Mode",
            isDarkMode = true
        )
    }

    override val values: Sequence<AppScaffoldPreviewConfig> = previewConfigLight + previewConfigDark

    override fun getDisplayName(index: Int): String {
        return values.elementAt(index).configName
    }
}

@VisibleForTesting
internal data class AppScaffoldPreviewConfig(
    val configName: String,
    val uiState: MainActivityViewModel.UiState,
    val currentDestination: DestinationSpec,
    val isDarkMode: Boolean
)

