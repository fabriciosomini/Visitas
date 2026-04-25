package com.msmobile.visitas.conversation

import androidx.annotation.VisibleForTesting
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.msmobile.visitas.MainActivityViewModel
import com.msmobile.visitas.util.IntentState
import java.util.UUID

@VisibleForTesting
internal class PreviewConfigProvider : PreviewParameterProvider<PreviewConfig> {

    private val previewConfigLight = sequenceOf(
        PreviewConfig(
            configName = "Conversation list",
            mainActivityUiState = previewMainActivityUiState,
            conversationUiState = previewConversationUiState,
            isDarkMode = false
        ),
        PreviewConfig(
            configName = "Empty list",
            mainActivityUiState = previewMainActivityUiState,
            conversationUiState = previewConversationUiState.copy(
                conversations = emptyList()
            ),
            isDarkMode = false
        ),
        PreviewConfig(
            configName = "Filtering conversations",
            mainActivityUiState = previewMainActivityUiState,
            conversationUiState = previewConversationUiState.copy(
                filter = previewConversationUiState.filter.copy(search = "God")
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

    override val values: Sequence<PreviewConfig> = previewConfigLight + previewConfigDark

    override fun getDisplayName(index: Int): String {
        return values.elementAt(index).configName
    }
}

@VisibleForTesting
internal data class PreviewConfig(
    val configName: String,
    val mainActivityUiState: MainActivityViewModel.UiState,
    val conversationUiState: ConversationListViewModel.UiState,
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

private val previewConversationUiState = ConversationListViewModel.UiState(
    conversations = listOf(
        ConversationListViewModel.ConversationState(
            conversationId = UUID.randomUUID(),
            parentId = UUID.randomUUID(),
            question = "What will God's Kingdom do for us?",
            hide = false
        ),
        ConversationListViewModel.ConversationState(
            conversationId = UUID.randomUUID(),
            parentId = UUID.randomUUID(),
            question = "Does God hear all prayers?",
            hide = false
        )
    ),
    filter = ConversationListViewModel.ConversationFilter(search = "")
)

