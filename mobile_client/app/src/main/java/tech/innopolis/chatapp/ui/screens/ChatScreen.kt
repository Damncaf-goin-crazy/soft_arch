package tech.innopolis.chatapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.innopolis.chatapp.data.models.Message
import tech.innopolis.chatapp.ui.screens.components.MessageCell
import tech.innopolis.chatapp.ui.screens.state.ChatEvent
import tech.innopolis.chatapp.ui.screens.state.ChatState
import tech.innopolis.chatapp.ui.theme.ChatAppTheme


@Composable
fun ChatScreenRoot(viewModel: ChatViewModel) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.obtainEvent(ChatEvent.OnEnterScreen)
    }
    ChatScreen(
        state = state,
        onEvent = viewModel::obtainEvent
    )
}

@Composable
fun ChatScreen(
    state: ChatState,
    onEvent: (ChatEvent) -> Unit
) {
    var inputText by remember { mutableStateOf("") }
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    singleLine = true
                )
                IconButton(
                    onClick = {
                        onEvent(ChatEvent.OnSendMessageClick(inputText))
                    }
                ) {
                    Icon(Icons.AutoMirrored.Filled.Send, contentDescription = null)
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                reverseLayout = true,
            ) {
                items(state.messages) { message ->
                    MessageCell(content = message.content, createdAt = message.createdAt)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatAppTheme {
        ChatScreen(
            state = ChatState(
                listOf(
                    Message(content = "Text", createdAt = "12:31"),
                    Message(content = "Text", createdAt = "12:31"),
                    Message(content = "Text", createdAt = "12:31"),
                    Message(content = "Text", createdAt = "12:31")
                )
            ),
            onEvent = {}
        )
    }
}
