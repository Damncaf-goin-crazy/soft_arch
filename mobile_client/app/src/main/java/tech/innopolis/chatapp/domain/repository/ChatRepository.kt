package tech.innopolis.chatapp.domain.repository

import tech.innopolis.chatapp.data.models.Message
import tech.innopolis.chatapp.domain.responces.SendMessageResponse

interface ChatRepository {
    suspend fun getMessagesCount(): Int

    suspend fun sendMessage(message: String): SendMessageResponse

    suspend fun getMessages(): List<Message>
}