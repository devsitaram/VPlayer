package com.edu.vplayer.features.presentation.ui.screen

import android.content.Context
import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun SubjectViewScreen() {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    Button(
        onClick = {
            // share preference
            val editor = sharedPreferences.edit()
            editor.putString("login_screen", "").apply()
        }
    ) {
        Text(text = "Subject")
    }
}