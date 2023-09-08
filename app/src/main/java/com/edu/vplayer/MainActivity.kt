package com.edu.vplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edu.vplayer.features.presentation.ui.screen.LoginViewScreen
import com.edu.vplayer.features.presentation.ui.screen.NavigationViewScreen
import com.edu.vplayer.features.presentation.ui.screen.ScreenList
import com.edu.vplayer.features.presentation.ui.screen.SplashViewScreen
import com.edu.vplayer.features.presentation.ui.screen.SubjectViewScreen
import com.edu.vplayer.features.presentation.ui.screen.VideoViewScreen
import com.edu.vplayer.ui.theme.VPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // create the Shared Preferences
        val getSharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)
        val getUserDevice = getSharedPreferences.getString("login_screen", "")

        setContent {
            VPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavigationViewScreen(navHostController = navController, getUserDevice = getUserDevice)
                }
            }
        }
    }
}