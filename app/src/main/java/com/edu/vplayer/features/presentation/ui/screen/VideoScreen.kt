package com.edu.vplayer.features.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
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