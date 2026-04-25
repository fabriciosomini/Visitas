package com.msmobile.visitas.visit

import androidx.annotation.VisibleForTesting
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.msmobile.visitas.MainActivityViewModel
import com.msmobile.visitas.summary.SummaryViewModel
import com.msmobile.visitas.util.AddressProvider
import com.msmobile.visitas.util.IntentState
import java.time.LocalDateTime
import java.util.UUID

private val previewDate1 = LocalDateTime.of(2024, 1, 15, 10, 12)
private val previewDate2 = previewDate1.plusWeeks(1)
private val previewDate3 = previewDate1.plusWeeks(2)

@VisibleForTesting
internal class VisitListPreviewConfigProvider : PreviewParameterProvider<VisitListPreviewConfig> {

    private val previewConfigLight = sequenceOf(
        VisitListPreviewConfig(
            configName = "Summary details collapsed",
            mainActivityUiState = previewMainActivityUiState,
            summaryUiState = previewSummaryUiState,
            visitListUiState = previewVisitListUiState,
            isDarkMode = false
        ),
        VisitListPreviewConfig(
            configName = "Summary details expanded",
            mainActivityUiState = previewMainActivityUiState,
            summaryUiState = previewSummaryUiState.copy(shouldShowSummaryDetails = true),
            visitListUiState = previewVisitListUiState,
            isDarkMode = false
        ),
        VisitListPreviewConfig(
            configName = "Loading visits",
            mainActivityUiState = previewMainActivityUiState,
            summaryUiState = previewSummaryUiState,
            visitListUiState = previewVisitListUiState.copy(isLoadingVisits = true),
            isDarkMode = false
        ),
        VisitListPreviewConfig(
            configName = "Filtering visits",
            mainActivityUiState = previewMainActivityUiState,
            summaryUiState = previewSummaryUiState,
            visitListUiState = previewVisitListUiState.copy(
                visitList = emptyList(),
                filter = previewVisitListUiState.filter.copy(search = "Maria")
            ),
            isDarkMode = false
        ),
        VisitListPreviewConfig(
            configName = "Location rationale",
            mainActivityUiState = previewMainActivityUiState,
            summaryUiState = previewSummaryUiState,
            visitListUiState = previewVisitListUiState.copy(
                showLocationRationale = true
            ),
            isDarkMode = false
        )
    )

    private val previewConfigDark = previewConfigLight.map { config ->
        config.copy(
            configName = "${config.configName} - Dark Mode",
            isDarkMode = true
        )
    }

    override val values: Sequence<VisitListPreviewConfig> = previewConfigLight + previewConfigDark

    override fun getDisplayName(index: Int): String {
        return values.elementAt(index).configName
    }
}

@VisibleForTesting
internal data class VisitListPreviewConfig(
    val configName: String,
    val mainActivityUiState: MainActivityViewModel.UiState,
    val summaryUiState: SummaryViewModel.UiState,
    val visitListUiState: VisitListViewModel.UiState,
    val isDarkMode: Boolean
)

private val previewMainActivityUiState = MainActivityViewModel.UiState(
    scaffoldState = MainActivityViewModel.ScaffoldState(
        showBottomBar = true,
        showFAB = true
    ),
    eventState = MainActivityViewModel.UiEventState.Idle,
    intentState = IntentState.None
)

private val previewSummaryUiState = SummaryViewModel.UiState(
    returnVisitCount = "0",
    bibleStudyCount = "0",
    selectedMonth = previewDate1,
    shouldShowSummaryDetails = false,
    isSummaryMenuExpanded = false,
    summaryFilterOptions = listOf()
)

private val previewVisitListUiState = VisitListViewModel.UiState(
    visitList = listOf(
        VisitListViewModel.VisitHouseholderState(
            householderId = UUID.randomUUID(),
            householderName = "Maria Madalena",
            householderAddress = "Rua das Oliveiras, 12 - Próximo ao jardim do Getsêmani",
            householderAddressDistance = AddressProvider.AddressDistance.Nearby(100f),
            date = previewDate1,
            isDone = false,
            hasToBeRescheduled = false,
            isPendingVisitMenuExpanded = false,
            subject = "O que é o Reino de Deus?",
            subjectPreview = "O que é o Reino de Deus? — Daniel 2:44",
            hide = false,
            visitId = UUID.randomUUID(),
            type = VisitType.FIRST_VISIT,
            householderLatitude = 0.0,
            householderLongitude = 0.0
        ),
        VisitListViewModel.VisitHouseholderState(
            householderId = UUID.randomUUID(),
            householderName = "José de Arimateia",
            householderAddress = "Av. dos Cedros, 45",
            date = previewDate2,
            isDone = false,
            hasToBeRescheduled = true,
            isPendingVisitMenuExpanded = false,
            subjectPreview = "A ressurreição dos mortos — João 5:28, 29",
            hide = false,
            visitId = UUID.randomUUID(),
            type = VisitType.FIRST_VISIT,
            householderLatitude = 0.0,
            householderLongitude = 0.0,
            householderAddressDistance = AddressProvider.AddressDistance.FarAway(600f),
            subject = "A ressurreição dos mortos"
        ),
        VisitListViewModel.VisitHouseholderState(
            householderId = UUID.randomUUID(),
            householderName = "Nicodemos",
            householderAddress = "Rua dos Fariseus, 7",
            date = previewDate3,
            isDone = false,
            hasToBeRescheduled = false,
            isPendingVisitMenuExpanded = false,
            subjectPreview = "Quem é Jesus Cristo? — Lucas 1:31-33",
            hide = false,
            visitId = UUID.randomUUID(),
            type = VisitType.FIRST_VISIT,
            householderLatitude = 0.0,
            householderLongitude = 0.0,
            householderAddressDistance = AddressProvider.AddressDistance.NoData,
            subject = "Quem é Jesus Cristo?"
        ),
    ),
    selectedTabIndex = 0,
    filter = VisitListViewModel.VisitFilter(
        search = "",
        dateFilter = VisitListViewModel.VisitDateFilter.All,
        distanceFilter = VisitListViewModel.VisitDistanceFilter.All
    ),
    visitsFilterOptions = VisitListDateFilterOption.entries,
    selectedVisitFilterOption = VisitListDateFilterOption.ScheduledForNextDays,
    isVisitsFilterMenuExpanded = false,
    selectedDate = previewDate1,
    showLocationRationale = false,
    showLocationPermissionDialog = false,
    isLoadingVisits = false,
    showNearbyVisits = true,
    showBackupSheet = false,
    showVisitMapSheet = false,
    currentCoordinates = Pair(0.0, 0.0),
    visitMapState = VisitMapState.Empty,
    previewBackupFileState = VisitListViewModel.PreviewBackupFileState.None
)

