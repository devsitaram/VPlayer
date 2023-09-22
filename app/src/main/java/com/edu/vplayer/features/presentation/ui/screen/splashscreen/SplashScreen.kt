package com.edu.vplayer.features.presentation.ui.screen.splashscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.edu.vplayer.features.presentation.ui.navigation.NavigationItem
import com.edu.vplayer.features.presentation.ui.navigation.ScreenList

@Composable
fun SplashViewScreen(navHostController: NavHostController, getUserDevice: String?) {
    LaunchedEffect(key1 = true) {
        if (getUserDevice.isNullOrEmpty()) {
            navHostController.navigate(ScreenList.LoginScreen.route)
        } else {
            navHostController.navigate(ScreenList.BottomBarScreen.route)
        }
    }
//    Box(modifier = Modifier.fillMaxSize()) {
//        Image(painter = painterResource(id = R.mipmap.img_player), contentDescription = null)
//    }
}