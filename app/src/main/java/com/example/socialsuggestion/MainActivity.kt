package com.example.socialsuggestion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.socialsuggestion.ui.theme.SocialSuggestionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocialSuggestionTheme {
                Column() {
                    //ARRAY
                    var timeOfDay = arrayOf("Morning", "Afternoon", "Evening")
                    var suggestionOfDay = arrayOf(
                        "Send a Good Morning Text to a family member",
                        "Share a funny meme or interesting link with a friend",
                        "leave a thoughtful comment on a friend's post"
                    )

                    var text by remember { mutableStateOf("") }
                    var results by remember {mutableStateOf("")}
                    Column() {
                        Text(text = "Social Suggestion")
                        OutlinedTextField(
                            value = text,
                            onValueChange = { text = it },
                            label = {Text(text = "Enter time of the day")}
                        )

                        Button(
                            onClick = {
                                results = when (text.trim().lowercase()) {
                                    "morning" -> "Send a Good morning text"
                                    "afternoon" -> "Share a funny meme or interesting link with a friend"
                                    "evening" ->"Leave a thoughtful comment on a friend's post"
                                    else -> "Invalid output"

                                }
                            }

                            
                        ) {
                            Text("Enter")
                        }

                        Text(text = results)

                    }
                }
            }
        }
    }
}

