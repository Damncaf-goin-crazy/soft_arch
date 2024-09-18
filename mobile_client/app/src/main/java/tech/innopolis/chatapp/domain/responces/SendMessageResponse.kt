package tech.innopolis.chatapp.domain.responces

import com.google.gson.annotations.SerializedName

data class SendMessageResponse(
    @SerializedName("content")
    val content: String,

    @SerializedName("created_at")
    val createdAt: String
)