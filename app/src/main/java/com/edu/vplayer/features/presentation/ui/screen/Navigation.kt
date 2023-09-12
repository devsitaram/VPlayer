package com.edu.vplayer.features.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.edu.vplayer.features.presentation.ViewModel.VideoViewModel

@Composable
fun NavigationViewScreen(navHostController: NavHostController, getUserDevice: String?) {

    val videoViewModel: VideoViewModel = viewModel()

    NavHost(
        navController = navHostController,
        startDestination = ScreenList.SubjectScreen.route
    ) {
        composable(ScreenList.SplashScreen.route) {
            SplashViewScreen(navHostController, getUserDevice)
        }
        composable(ScreenList.LoginScreen.route) {
            LoginViewScreen(navHostController)
        }
        composable(ScreenList.SubjectScreen.route) {
            SubjectViewScreen(navHostController, videoViewModel)
        }
        composable(ScreenList.VideoScreen.route) {
            VideoViewScreen(videoViewModel)
        }
    }
}

sealed class ScreenList(val route: String) {
    object SplashScreen : ScreenList("SplashScreen")
    object LoginScreen : ScreenList("LoginScreen")
    object SubjectScreen : ScreenList("SubjectScreen")
    object VideoScreen : ScreenList("VideoScreen")
}