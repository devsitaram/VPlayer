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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.edu.teachingnepal.features.classroom.ClassRoomScreenView
import com.edu.vplayer.features.data.resource.remote.api.ApiConstants.SUBJECT_ID
import com.edu.vplayer.features.data.resource.remote.api.ApiConstants.SUBJECT_NAME
import com.edu.vplayer.features.presentation.ui.screen.HomeViewScreen
import com.edu.vplayer.features.presentation.ui.screen.login.ForgotViewScreen
import com.edu.vplayer.features.presentation.ui.screen.login.LoginViewScreen
import com.edu.vplayer.features.presentation.ui.screen.login.LogoutViewScreen
import com.edu.vplayer.features.presentation.ui.screen.profile.ProfileViewScreen
import com.edu.vplayer.features.presentation.ui.screen.register.RegisterViewScreen
import com.edu.vplayer.features.presentation.ui.screen.splashscreen.SplashViewScreen
import com.edu.vplayer.features.presentation.ui.screen.subject.SubjectViewScreen
import com.edu.vplayer.features.presentation.ui.screen.video.VideoUrlViewScreen
import com.edu.vplayer.features.presentation.ui.screen.video.VideoViewScreen

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
            LoginViewScreen(navController)
//            MainNavViewScreen()
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
//            ClassRoomScreenView(navController)
        }
        composable(
            route = ScreenList.VideoUrlScreen.route,
            arguments = listOf(
                navArgument(name = SUBJECT_ID ) {
                    type = NavType.StringType
                },
                        navArgument(name = SUBJECT_NAME ) {
                    type = NavType.StringType
                }
            )
        ) {navBackController ->
            val subjId = navBackController.arguments?.getString(SUBJECT_ID)?.toInt()
            val subjectName = navBackController.arguments?.getString(SUBJECT_NAME)

            VideoUrlViewScreen(subjId,subjectName, navController)
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
     object VideoUrlScreen: ScreenList("VideoUrlScreen/{$SUBJECT_ID}/{$SUBJECT_NAME}")

}


sealed class NavigationItem(val route: String, val title: String, val icons: ImageVector) {
    object Home : NavigationItem("home ", "Home", Icons.Default.Home)
    object Subject : NavigationItem("subject ", "Subject", Icons.Default.Subject)
    object Classroom : NavigationItem("classroom ", "Classroom", Icons.Default.Class)
    object APTutor : NavigationItem("apTutor ", "APTutor", (Icons.Default.Message))
    object Profile : NavigationItem("profile ", "Profile", Icons.Default.MoreVert)

}


