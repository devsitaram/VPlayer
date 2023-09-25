package com.edu.vplayer.features.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Class
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Subject
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.edu.teachingnepal.features.classroom.ClassRoomScreenView
import com.edu.vplayer.features.presentation.ui.screen.HomeViewScreen
import com.edu.vplayer.features.presentation.ui.screen.aptutor.APTutorScreenView
import com.edu.vplayer.features.presentation.ui.screen.login.ForgotViewScreen
import com.edu.vplayer.features.presentation.ui.screen.login.LoginViewScreen
import com.edu.vplayer.features.presentation.ui.screen.login.LogoutViewScreen
import com.edu.vplayer.features.presentation.ui.screen.profile.ProfileViewScreen
import com.edu.vplayer.features.presentation.ui.screen.register.RegisterViewScreen
import com.edu.vplayer.features.presentation.ui.screen.splashscreen.SplashViewScreen
import com.edu.vplayer.features.presentation.ui.screen.subject.SubjectViewScreen
import com.edu.vplayer.features.presentation.ui.screen.video.VideoViewScreen
import com.google.android.material.bottomappbar.BottomAppBar

@Composable
fun MainNavViewScreen(navController: NavHostController, getUserDevice: String?) {
    NavHost(
        navController = navController,
        startDestination = ScreenList.SplashScreen.route
    ) {
        composable(ScreenList.SplashScreen.route) {
            SplashViewScreen(navController, getUserDevice)
        }
        composable(ScreenList.LoginScreen.route) {
//            LoginViewScreen(navController)
            MainNavViewScreen()

        }
        composable(ScreenList.BottomBarScreen.route) {
            MainNavViewScreen()
        }
        composable(ScreenList.RegisterScreen.route) {
            RegisterViewScreen(navController)
        }
        composable(ScreenList.ForgotScreen.route) {
            ForgotViewScreen(navController)
        }

    }
}


@Composable
fun BottomAppBarController(navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

        composable(NavigationItem.Home.route) {
            HomeViewScreen()
        }
        composable(NavigationItem.Subject.route) {
            SubjectViewScreen(navController)
        }
        composable(NavigationItem.Classroom.route) {
            ClassRoomScreenView(navController)
        }
        composable(NavigationItem.APTutor.route) {
            APTutorScreenView(navController)
        }
        composable(NavigationItem.Profile.route) {
            ProfileViewScreen(navController)
        }
        composable(ScreenList.LogoutScreen.route) {
            LogoutViewScreen(navController)
        }
        composable(ScreenList.VideoScreen.route) {
            VideoViewScreen(navController)
        }
    }
}

sealed class ScreenList(val route: String) {
    object SplashScreen : ScreenList("SplashScreen")
    object LoginScreen : ScreenList("LoginScreen")
    object VideoScreen : ScreenList("VideoScreen")
    object RegisterScreen : ScreenList("RegisterScreen")
    object ForgotScreen : ScreenList("ForgotScreen")
    object LogoutScreen : ScreenList("LogoutScreen")
    object BottomBarScreen : ScreenList("BottomBarScreen")

}


sealed class NavigationItem(val route: String, val title: String, val icons: ImageVector) {
    object Home : NavigationItem("home ", "Home", Icons.Default.Home)
    object Subject : NavigationItem("subject ", "Subject", Icons.Default.Subject)
    object Classroom : NavigationItem("classroom ", "Classroom", Icons.Default.Class)
    object APTutor : NavigationItem("apTutor ", "APTutor", (Icons.Default.Message))
    object Profile : NavigationItem("profile ", "Profile", Icons.Default.MoreVert)

}


