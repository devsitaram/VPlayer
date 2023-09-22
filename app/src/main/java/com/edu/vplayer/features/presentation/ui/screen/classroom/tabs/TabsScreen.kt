package com.edu.vplayer.features.presentation.ui.screen.classroom.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.edu.vplayer.ui.theme.skyBlue
import com.edu.vplayer.ui.theme.skyGreen

@Composable
fun TeachersSessionView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(skyBlue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp),
            color = Color.Blue,
            strokeWidth = 5.dp
        )
    }
}


@Composable
fun AssignmentsView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(skyGreen),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp),
            color = Color.Blue,
            strokeWidth = 5.dp
        )
    }
}


@Composable
fun TeachersContentView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp),
            color = Color.Blue,
            strokeWidth = 5.dp
        )
    }
}


