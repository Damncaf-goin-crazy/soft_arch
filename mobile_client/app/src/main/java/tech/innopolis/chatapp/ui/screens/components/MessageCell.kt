package tech.innopolis.chatapp.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.innopolis.chatapp.ui.theme.ChatAppTheme
import tech.innopolis.chatapp.ui.theme.PurpleGrey80

@Composable
fun MessageCell(content: String, createdAt: String) {
    Box(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 48f,
                    topEnd = 48f,
                    bottomEnd = 48f
                )
            )
            .background(PurpleGrey80)
            .padding(12.dp)
    ) {
        Column() {
            Text(text = content)
            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .height(5.dp),
                text = createdAt,
                fontSize = 5.sp,
                lineHeight = 5.sp,
                softWrap = true
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MessageCellPreview() {
    ChatAppTheme {
        MessageCell(content = "Text of the message", createdAt = "12:34")
    }
}