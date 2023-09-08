package com.edu.vplayer.features.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.material.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.edu.vplayer.R
import com.edu.vplayer.features.presentation.ui.components.ButtonView

@Composable
fun VideoViewScreen() {
    ButtonView(
        onClick = { /*TODO*/ },
        modifier = Modifier,
        btnColor = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.purple_500)
        ),
        text = "",
        textStyle = TextStyle()
    )
}