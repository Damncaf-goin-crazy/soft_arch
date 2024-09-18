package tech.innopolis.chatapp.ui.screens.state

sealed interface ChatEvent {
    data object OnEnterScreen : ChatEvent
    data class OnSendMessageClick(val messageContent: String): ChatEvent
}