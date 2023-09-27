package com.edu.vplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.edu.vplayer.features.presentation.ui.navigation.MainNavViewScreen
import com.edu.vplayer.ui.theme.VPlayerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // create the Shared Preferences
        val getSharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)
        val getUserDevice = getSharedPreferences.getString("login_screen", "")

        setContent {
            VPlayerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MainNavViewScreen(navController = navController, getUserDevice = getUserDevice)
                }
            }
        }
    }
}




