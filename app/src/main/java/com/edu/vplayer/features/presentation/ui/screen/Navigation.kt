package com.edu.vplayer.features.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationViewScreen(navHostController: NavHostController, getUserDevice: String?) {
    NavHost(
        navController = navHostController,
        startDestination = ScreenList.SplashScreen.route
    ) {
        composable(ScreenList.SplashScreen.route) {
            SplashViewScreen(navHostController, getUserDevice)
        }
        composable(ScreenList.LoginScreen.route) {
            LoginViewScreen(navHostController)
        }
        composable(ScreenList.SubjectScreen.route) {
            SubjectViewScreen()
        }
        composable(ScreenList.VideoScreen.route) {
            VideoViewScreen()
        }
    }
}

sealed class ScreenList(val route: String) {
    object SplashScreen : ScreenList("SplashScreen")
    object LoginScreen : ScreenList("LoginScreen")
    object SubjectScreen : ScreenList("SubjectScreen")
    object VideoScreen : ScreenList("VideoScreen")
}