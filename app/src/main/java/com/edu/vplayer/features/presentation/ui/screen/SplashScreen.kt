package com.edu.vplayer.features.presentation.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.edu.vplayer.R
import com.edu.vplayer.features.presentation.ui.navigation.ScreenList

@Composable
fun SplashViewScreen(navHostController: NavHostController, getUserDevice: String?) {
    LaunchedEffect(key1 = true) {
        if (getUserDevice.isNullOrEmpty()) {
            navHostController.navigate(ScreenList.LoginScreen.route)
        } else {
            navHostController.navigate(ScreenList.SubjectScreen.route)
        }
    }
//    Box(modifier = Modifier.fillMaxSize()) {
//        Image(painter = painterResource(id = R.mipmap.img_player), contentDescription = null)
//    }
}