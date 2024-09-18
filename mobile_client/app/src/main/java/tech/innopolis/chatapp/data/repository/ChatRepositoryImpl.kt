package tech.innopolis.chatapp.data.repository

import kotlinx.coroutines.delay
import tech.innopolis.chatapp.data.models.Message
import tech.innopolis.chatapp.domain.ChatApi
import tech.innopolis.chatapp.domain.repository.ChatRepository
import tech.innopolis.chatapp.domain.responces.SendMessageResponse

class ChatRepositoryImpl(
    private val api: ChatApi
) : ChatRepository {

    override suspend fun getMessagesCount(): Int {
        val response = api.getMessagesCount()
        return if (response.isSuccessful) {
            response.body() ?: 0
        } else {
            0
        }
    }

    override suspend fun sendMessage(message: String): SendMessageResponse {
        val response = api.sendMessage(message)
        return response.body() ?: throw Exception("Error sending message")
    }

    override suspend fun getMessages(): List<Message> {
        return api.getMessages()
    }


}
