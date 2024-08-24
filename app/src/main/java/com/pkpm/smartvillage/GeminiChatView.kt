package com.pkpm.smartvillage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.TextPart
import kotlinx.coroutines.launch
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun GeminiChatView(
    apiKey: String,
    appThemeColor: Color = Color(0xFFC0DDDF),
    chatContext: List<GeminiContent> = emptyList()
) {
    val lazyColumnListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val isLoading = remember { mutableStateOf(false) }
    val chatDataList = remember { mutableStateOf(listOf<ChatMember>()) }

    val generativeModel = remember {
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = apiKey
        )
    }

    val chat = remember {
        generativeModel.startChat(history = chatContext.map {
            Content(role = it.role, parts = listOf(TextPart(text = it.text)))
        })
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = appThemeColor,
        ) {
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(55.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Black, CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "WISE",
                        color = Color.Black,
                        fontSize = 24.sp,
                    )

                    Text(
                        text = stringResource(id = R.string.specialist_text),
                        color = Color.Black,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = lazyColumnListState
            ) {
                items(chatDataList.value) { chat ->
                    ChatBubble(
                        text = chat.text,
                        memberType = chat.memberType,
                        appThemeColor = appThemeColor
                    )
                }
            }
        }

        RoundedCornerTextFieldWithSend(
            modifier = Modifier.fillMaxWidth(),
            onSendClick = {
                coroutineScope.launch {
                    chatDataList.value += listOf(ChatMember(MemberType.USER, it))
                    lazyColumnListState.animateScrollToItem(chatDataList.value.size - 1)
                    isLoading.value = true
                    try {
                        val response = chat.sendMessage(it)
                        chatDataList.value += listOf(
                            ChatMember(
                                MemberType.BOT,
                                response.text ?: ""
                            )
                        )
                        lazyColumnListState.animateScrollToItem(chatDataList.value.size - 1)
                        isLoading.value = false
                    } catch (ex: Exception) {
                        isLoading.value = false
                        ex.printStackTrace()
                    }
                }
            },
            isLoading.value,
            appThemeColor
        )
    }
}
@Composable
fun ChatBubble(
    text: String,
    memberType: MemberType,
    appThemeColor: Color
) {
    val bubbleColor = if (memberType == MemberType.USER) {
        appThemeColor // Use appThemeColor for user messages
    } else {
        appThemeColor // Use appThemeColor for bot messages
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = if (memberType == MemberType.USER) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (memberType == MemberType.BOT) {
            Icon(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Bot Avatar",
                modifier = Modifier.size(40.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        Box(
            modifier = Modifier
                .background(
                    color = bubbleColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
        ) {
            Text(
                text = text,
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.widthIn(max = 240.dp)
            )
        }

        if (memberType == MemberType.USER) {
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "User Avatar",
                modifier = Modifier.size(40.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}


@Composable
fun RoundedCornerTextFieldWithSend(
    modifier: Modifier = Modifier,
    onSendClick: (String) -> Unit,
    isLoading: Boolean,
    appThemeColor: Color
) {
    val focusRequester = remember { FocusRequester() }
    val textState = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(modifier = modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { Text(stringResource(R.string.pembukaan)) },
            maxLines = 6,
            modifier = Modifier
                .weight(1f)
                .focusRequester(focusRequester),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = appThemeColor,
                focusedLabelColor = Color.Black,
                unfocusedBorderColor = appThemeColor,
                unfocusedLabelColor = Color.Black,
                cursorColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(36.dp),
                strokeWidth = 4.dp,
                color = appThemeColor,
            )
        } else {
            Button(
                modifier = Modifier.size(50.dp),
                contentPadding = PaddingValues(0.dp),
                enabled = textState.value.isNotBlank(),
                onClick = {
                    onSendClick(textState.value)
                    textState.value = ""
                    keyboardController?.hide() // Hide the keyboard
                },
                shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = appThemeColor
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "Send",
                    tint = Color.Black
                )
            }
        }
    }


}

data class GeminiContent(var role: String, var text: String)
data class ChatMember(var memberType: MemberType, var text: String)
enum class MemberType { BOT, USER }