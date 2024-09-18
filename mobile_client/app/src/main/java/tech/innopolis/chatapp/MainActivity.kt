package tech.innopolis.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import tech.innopolis.chatapp.ui.screens.ChatScreen
import tech.innopolis.chatapp.ui.screens.ChatScreenRoot
import tech.innopolis.chatapp.ui.screens.ChatViewModel
import tech.innopolis.chatapp.ui.theme.ChatAppTheme

    @AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatAppTheme {
                val viewModel = hiltViewModel<ChatViewModel>()
                ChatScreenRoot(viewModel)
            }
        }
    }
}



