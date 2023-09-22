package com.edu.vplayer.features.presentation.ui.screen.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.edu.vplayer.features.presentation.ui.components.IconButtonView
import com.edu.vplayer.features.presentation.ui.components.IconView
import com.edu.vplayer.features.presentation.ui.components.TextView

@Composable
fun LogoutViewScreen(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            IconView(
                imageVector = Icons.Default.Logout,
                contentDescription = null,
                tint = Color.LightGray
            )
        }
        TextView(text = "Logout", style = TextStyle(fontSize = 20.sp))
    }

}