package com.msmobile.visitas.visit

import androidx.annotation.VisibleForTesting
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.msmobile.visitas.MainActivityViewModel
import com.msmobile.visitas.R
import com.msmobile.visitas.util.IntentState
import com.msmobile.visitas.util.StringResource
import java.time.LocalDateTime
import java.util.UUID

private val previewDate1 = LocalDateTime.of(2024, 1, 15, 10, 12)
private val previewDate2 = previewDate1.plusWeeks(1)

@VisibleForTesting
internal class VisitDetailPreviewConfigProvider : PreviewParameterProvider<VisitDetailPreviewConfig> {

    private val previewConfigLight = sequenceOf(
        VisitDetailPreviewConfig(
            configName = "New Visit",
            mainActivityUiState = previewMainActivityUiState,
            householderId = null,
            uiState = previewVisitDetailUiState.copy(
                householder = VisitDetailViewModel.HouseholderState(
                    id = UUID.randomUUID(),
                    name = "",
                    address = "",
                    notes = "",
                    showClearName = false,
                    addressState = VisitDetailViewModel.HouseholderAddressState.LoadLocation,
                    showClearNotes = false,
                    isLoadingAddress = false,
                    showExpandNotes = false,
                    isNotesExpanded = false,
                ),
                visitList = listOf(
                    VisitDetailViewModel.VisitState(
                        id = UUID.randomUUID(),
                        subject = "",
                        date = previewDate1,
                        isDone = false,
                        householderId = UUID.randomUUID(),
                        canBeRemoved = false,
                        orderIndex = 0,
                        isConversationListExpanded = false,
                        isVisitTypeListExpanded = false,
                        visitType = VisitDetailViewModel.VisitTypeState(
                            type = VisitType.FIRST_VISIT,
                            description = StringResource(
                                textResId = R.string.first_visit,
                                arguments = listOf()
                            )
                        ),
                        nextConversationSuggestion = null,
                        showNextVisitSuggestion = false,
                        showClearSubject = false,
                        wasRemoved = false,
                        caretPosition = 0
                    )
                )
            ),
            isDarkMode = false
        ),
        VisitDetailPreviewConfig(
            configName = "Edit Visit",
            mainActivityUiState = previewMainActivityUiState,
            householderId = UUID.randomUUID(),
            uiState = previewVisitDetailUiState.copy(
                visitList = listOf(
                    previewVisitUiState.copy(canBeRemoved = false)
                )
            ),
            isDarkMode = false
        ),
        VisitDetailPreviewConfig(
            configName = "Loading Address",
            mainActivityUiState = previewMainActivityUiState,
            householderId = null,
            uiState = previewVisitDetailUiState.copy(
                householder = previewVisitDetailUiState.householder.copy(
                    address = "",
                    isLoadingAddress = true
                )
            ),
            isDarkMode = false
        ),
        VisitDetailPreviewConfig(
            configName = "Multiple Visits",
            mainActivityUiState = previewMainActivityUiState,
            householderId = null,
            uiState = previewVisitDetailUiState.copy(
                visitList = listOf(
                    previewVisitUiState,
                    previewVisitUiState.copy(
                        id = UUID.randomUUID(),
                        subject = "Como podemos ter certeza de que há um Criador?",
                        isDone = false,
                        canBeRemoved = true
                    )
                )
            ),
            isDarkMode = false
        ),
        VisitDetailPreviewConfig(
            configName = "Next Visit Suggestion",
            mainActivityUiState = previewMainActivityUiState,
            householderId = null,
            uiState = previewVisitDetailUiState.copy(
                visitList = listOf(
                    previewVisitUiState.copy(
                        showNextVisitSuggestion = true
                    ),
                    previewVisitUiState.copy(
                        id = UUID.randomUUID(),
                        subject = "Como podemos ter certeza de que há um Criador?",
                        isDone = false,
                        canBeRemoved = true
                    )
                )
            ),
            isDarkMode = false
        ),
        VisitDetailPreviewConfig(
            configName = "Time Preference Error",
            mainActivityUiState = previewMainActivityUiState,
            householderId = UUID.randomUUID(),
            uiState = previewVisitDetailUiState.copy(
                householder = previewVisitDetailUiState.householder.copy(
                    preferredDay = VisitPreferredDay.SATURDAY,
                    preferredTime = VisitPreferredTime.AFTERNOON
                ),
                visitList = listOf(
                    previewVisitUiState.copy(
                        isDone = false,
                        canBeRemoved = false,
                        hasVisitTimeError = true
                    ),
                    previewVisitUiState.copy(
                        id = UUID.randomUUID(),
                        subject = "Como podemos ter certeza de que há um Criador?",
                        isDone = false,
                        canBeRemoved = true,
                        hasVisitTimeError = false
                    )
                ),
                eventState = VisitDetailViewModel.UiEventState.ValidationError
            ),
            isDarkMode = false
        ),
        VisitDetailPreviewConfig(
            configName = "Notes Expanded",
            mainActivityUiState = previewMainActivityUiState,
            householderId = UUID.randomUUID(),
            uiState = previewVisitDetailUiState.copy(
                householder = previewVisitDetailUiState.householder.copy(
                    notes = "Morador receptivo, prefere visitas pela manhã.\nTem interesse em estudar a Bíblia.",
                    showClearNotes = false,
                    showExpandNotes = true,
                    isNotesExpanded = true
                ),
                visitList = listOf(previewVisitUiState.copy(canBeRemoved = false))
            ),
            isDarkMode = false
        ),
        VisitDetailPreviewConfig(
            configName = "Notes Collapsed",
            mainActivityUiState = previewMainActivityUiState,
            householderId = UUID.randomUUID(),
            uiState = previewVisitDetailUiState.copy(
                householder = previewVisitDetailUiState.householder.copy(
                    notes = "Morador receptivo, prefere visitas pela manhã.\nTem interesse em estudar a Bíblia.",
                    showClearNotes = false,
                    showExpandNotes = true,
                    isNotesExpanded = false
                ),
                visitList = listOf(previewVisitUiState.copy(canBeRemoved = false))
            ),
            isDarkMode = false
        ),
    )

    private val previewConfigDark = previewConfigLight.map { config ->
        config.copy(
            configName = "${config.configName} - Dark Mode",
            isDarkMode = true
        )
    }

    override val values: Sequence<VisitDetailPreviewConfig> = previewConfigLight + previewConfigDark

    override fun getDisplayName(index: Int): String {
        return values.elementAt(index).configName
    }
}

@VisibleForTesting
internal data class VisitDetailPreviewConfig(
    val configName: String,
    val mainActivityUiState: MainActivityViewModel.UiState,
    val householderId: UUID?,
    val uiState: VisitDetailViewModel.UiState,
    val isDarkMode: Boolean
)

private val previewMainActivityUiState = MainActivityViewModel.UiState(
    scaffoldState = MainActivityViewModel.ScaffoldState(
        showBottomBar = false,
        showFAB = false
    ),
    eventState = MainActivityViewModel.UiEventState.Idle,
    intentState = IntentState.None
)

private val previewVisitUiState = VisitDetailViewModel.VisitState(
    id = UUID.randomUUID(),
    subject = "O que é o Reino de Deus?",
    date = previewDate2,
    isDone = true,
    householderId = UUID.randomUUID(),
    canBeRemoved = true,
    orderIndex = 0,
    isConversationListExpanded = false,
    isVisitTypeListExpanded = false,
    visitType = VisitDetailViewModel.VisitTypeState(
        type = VisitType.FIRST_VISIT,
        description = StringResource(
            textResId = R.string.first_visit,
            arguments = listOf()
        )
    ),
    nextConversationSuggestion = null,
    showNextVisitSuggestion = false,
    showClearSubject = false,
    wasRemoved = false,
    caretPosition = 0
)

private val previewVisitDetailUiState = VisitDetailViewModel.UiState(
    householder = VisitDetailViewModel.HouseholderState(
        id = UUID.randomUUID(),
        name = "Pedro",
        address = "Rua 1",
        notes = "Morador receptivo",
        showClearName = true,
        addressState = VisitDetailViewModel.HouseholderAddressState.LoadLocation,
        showClearNotes = false,
        isLoadingAddress = false,
        showExpandNotes = false,
        isNotesExpanded = false,
    ),
    visitList = listOf(previewVisitUiState),
    conversationList = listOf(),
    visitTypeList = listOf(),
    eventState = VisitDetailViewModel.UiEventState.Idle
)
