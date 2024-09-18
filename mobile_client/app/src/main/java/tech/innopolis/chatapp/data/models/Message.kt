package tech.innopolis.chatapp.data.models

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Message(
    val content: String,
    val createdAt: String
) {
        fun formatTime(timestampString: String): String {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val createdAt = timestampString.format(formatter)
        return createdAt
    }

}