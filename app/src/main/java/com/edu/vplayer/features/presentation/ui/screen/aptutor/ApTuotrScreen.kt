package com.edu.vplayer.features.presentation.ui.screen.aptutor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Attribution
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.vplayer.features.presentation.ui.components.ButtonAppBarViewAp
import com.edu.vplayer.ui.theme.Purple40


@Composable
fun APTutorScreenView(navController: NavHostController) {

    Column(modifier = Modifier.fillMaxWidth()) {
        ButtonAppBarViewAp(navController)
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(Purple40)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Text(
                    text = "We 're Online and   ready to help",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, top = 40.dp, end = 40.dp)
                )

                Text(
                    text = "Search our knowledge base or start a chat",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, top = 15.dp, end = 5.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 100.dp, end = 20.dp),
                contentAlignment = Alignment.Center
            ) {
//                SearchBarScreenAp(onClick = {}, navController)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 100.dp)
                        .shadow(2.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple40
                        )

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Send,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Text(
                                text = "New Conversation",
                                style = TextStyle(Color.White),
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 460.dp)
                        .background(Color.White),
                    horizontalArrangement = Arrangement.Center

                ) {
                    OutlinedButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Attribution, contentDescription =null )
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(text = "Add free live chat to your site")

                    }

                }
            }
        }
    }
}