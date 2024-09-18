package tech.innopolis.chatapp.domain

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import tech.innopolis.chatapp.data.models.Message
import tech.innopolis.chatapp.domain.responces.SendMessageResponse

interface ChatApi {

    @GET("count")
    suspend fun getMessagesCount(): Response<Int>

    @POST("ws")
    suspend fun sendMessage(@Body message: String): Response<SendMessageResponse>

    @GET("ws")
    suspend fun getMessages(): List<Message>

}