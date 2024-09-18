package tech.innopolis.chatapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import tech.innopolis.chatapp.domain.repository.ChatRepository
import tech.innopolis.chatapp.ui.screens.state.ChatEvent
import tech.innopolis.chatapp.ui.screens.state.ChatState
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
) : ViewModel() {
    private val _state = MutableStateFlow(ChatState())
    val state = _state.asStateFlow()

    fun obtainEvent(event: ChatEvent) {
        when (event) {
            is ChatEvent.OnSendMessageClick -> sendMessage(event.messageContent)
            is ChatEvent.OnEnterScreen -> loadMessages()
        }
    }

    private fun sendMessage(message: String){
        viewModelScope.launch {
            repository.sendMessage(message)
        }

    }

    private fun loadMessages() {
        viewModelScope.launch {
            repository.getMessages()
        }
    }

}