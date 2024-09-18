package tech.innopolis.chatapp.ui.screens.state

import tech.innopolis.chatapp.data.models.Message
import tech.innopolis.chatapp.domain.models.RootError

data class ChatState (
    val messages:List<Message> = emptyList(),
    val error: RootError? = null
)