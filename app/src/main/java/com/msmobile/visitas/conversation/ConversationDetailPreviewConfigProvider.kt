package com.msmobile.visitas.conversation

import androidx.annotation.VisibleForTesting
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.msmobile.visitas.MainActivityViewModel
import com.msmobile.visitas.conversation.ConversationDetailViewModel.ConversationState
import com.msmobile.visitas.util.IntentState
import java.util.UUID

@VisibleForTesting
internal class ConversationDetailPreviewConfigProvider :
    PreviewParameterProvider<ConversationDetailPreviewConfig> {

    private val previewConfigLight = sequenceOf(
        ConversationDetailPreviewConfig(
            configName = "With Delete Button",
            mainActivityUiState = previewMainActivityUiState,
            showDeleteButton = true,
            uiState = previewConversationDetailUiState,
            isDarkMode = false
        ),
        ConversationDetailPreviewConfig(
            configName = "Without Delete Button",
            mainActivityUiState = previewMainActivityUiState,
            showDeleteButton = false,
            uiState = previewConversationDetailUiState,
            isDarkMode = false
        ),
        ConversationDetailPreviewConfig(
            configName = "Single Conversation",
            mainActivityUiState = previewMainActivityUiState,
            showDeleteButton = true,
            uiState = previewConversationDetailUiState.copy(
                conversationList = listOf(
                    previewConversationDetailUiState.conversationList.first()
                )
            ),
            isDarkMode = false
        ),
        ConversationDetailPreviewConfig(
            configName = "Multiple Conversations",
            mainActivityUiState = previewMainActivityUiState,
            showDeleteButton = true,
            uiState = previewConversationDetailUiState.copy(
                conversationList = previewConversationDetailUiState.conversationList + listOf(
                    ConversationState(
                        id = UUID.randomUUID(),
                        question = "O que a Bíblia diz sobre a ressurreição?",
                        response = "Os mortos ressuscitarão — João 5:28, 29",
                        showQuestionClear = false,
                        showResponseClear = false,
                        orderIndex = 2,
                        conversationGroupId = UUID.randomUUID(),
                        canBeDeleted = true,
                        wasRemoved = false
                    )
                )
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

    override val values: Sequence<ConversationDetailPreviewConfig> = previewConfigLight + previewConfigDark

    override fun getDisplayName(index: Int): String? {
        return values.elementAt(index).configName
    }
}

@VisibleForTesting
internal data class ConversationDetailPreviewConfig(
    val configName: String,
    val mainActivityUiState: MainActivityViewModel.UiState,
    val showDeleteButton: Boolean,
    val uiState: ConversationDetailViewModel.UiState,
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

private val previewConversationDetailUiState = ConversationDetailViewModel.UiState(
    conversationList = listOf(
        ConversationState(
            id = UUID.randomUUID(),
            question = "O que é o Reino de Deus?",
            response = "É o governo celestial de Deus por meio de Jesus Cristo — Daniel 2:44",
            showQuestionClear = true,
            showResponseClear = false,
            orderIndex = 0,
            conversationGroupId = UUID.randomUUID(),
            canBeDeleted = false,
            wasRemoved = false
        ),
        ConversationState(
            id = UUID.randomUUID(),
            question = "Quem é o Rei do Reino de Deus?",
            response = "Jesus Cristo, o Filho de Deus — Lucas 1:31-33",
            showQuestionClear = false,
            showResponseClear = false,
            orderIndex = 1,
            conversationGroupId = UUID.randomUUID(),
            canBeDeleted = true,
            wasRemoved = false
        )
    ),
    eventState = ConversationDetailViewModel.UiEventState.Idle
)

