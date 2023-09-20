package com.edu.vplayer.features.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.edu.vplayer.features.presentation.ui.screen.login.ForgotViewScreen
import com.edu.vplayer.features.presentation.ui.screen.login.LoginViewScreen
import com.edu.vplayer.features.presentation.ui.screen.register.RegisterViewScreen
import com.edu.vplayer.features.presentation.ui.screen.splashscreen.SplashViewScreen
import com.edu.vplayer.features.presentation.ui.screen.subject.SubjectViewScreen
import com.edu.vplayer.features.presentation.ui.screen.video.VideoViewScreen

@Composable
fun NavigationViewScreen(navController: NavHostController, getUserDevice: String?) {
    NavHost(
        navController = navController,
        startDestination = ScreenList.SplashScreen.route
    ) {
        composable(ScreenList.SplashScreen.route) {
            SplashViewScreen(navController, getUserDevice)
        }
        composable(ScreenList.RegisterScreen.route) {
            RegisterViewScreen(navController)
        }
        composable(ScreenList.LoginScreen.route) {
            LoginViewScreen(navController)
        }
        composable(ScreenList.ForgotScreen.route) {
            ForgotViewScreen(navController)
        }
        composable(ScreenList.SubjectScreen.route) {
            SubjectViewScreen(navController)
        }
        composable(ScreenList.VideoScreen.route) {
            VideoViewScreen(navController)
        }

    }
}

sealed class ScreenList(val route: String) {
    object SplashScreen : ScreenList("SplashScreen")
    object LoginScreen : ScreenList("LoginScreen")
    object SubjectScreen : ScreenList("SubjectScreen")
    object VideoScreen : ScreenList("VideoScreen")
    object RegisterScreen : ScreenList("RegisterScreen")
    object ForgotScreen : ScreenList("ForgotScreen")



}


//object Destinations{
//    const   val Auth="Auth"
//    const val Home = "home/{user}"
//    const val VPlayer ="vPlayer"
//
//}