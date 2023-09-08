package com.edu.vplayer.features.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edu.vplayer.R
import com.edu.vplayer.features.presentation.ui.components.ButtonView
import com.edu.vplayer.features.presentation.ui.components.IconButtonView
import com.edu.vplayer.features.presentation.ui.components.IconView
import com.edu.vplayer.features.presentation.ui.components.InputTextFieldView
import com.edu.vplayer.features.presentation.ui.components.PainterImageView
import com.edu.vplayer.features.presentation.ui.components.PasswordTextFieldView
import com.edu.vplayer.features.presentation.ui.components.TextView

@Composable
fun LoginViewScreen(navHostController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val checked = remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalAlignment = Alignment.Start
            ) {
                PainterImageView(painterResource(id = R.mipmap.ic_login))
                Spacer(modifier = Modifier.padding(5.dp))
                TextView(
                    text = "Welcome Back!",
                    style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Gray),
                    fontSize = 20.sp,
                )

            }
            InputTextFieldView(
                value = email,
                onValueChange = { email = it },
                label = "",
                placeholder = "Enter Email",
                textStyle = TextStyle(),
                invalidMessage = "",
                leadingIcon = { IconView(imageVector = Icons.Default.Email) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            PasswordTextFieldView(
                value = password,
                onValueChange = { password = it },
                label = "",
                placeholder = "Enter Password",
                textStyle = TextStyle(),
                invalidMessage = "",
                leadingIcon = { IconView(imageVector = Icons.Default.Lock) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checked.value,
                    onCheckedChange = { isChecked -> checked.value = isChecked })
//                   TextView(text = "Remember Password is ${if (checked.value) "checked" else "unchecked"}")
                TextView(text = "Remember Password")
                Spacer(modifier = Modifier.padding(30.dp))
                Card(
                    modifier = Modifier
                        .width(182.dp)
                        .clickable { },
                    colors = CardDefaults.cardColors(Color.Transparent)
                ) {
                    TextView(text = "Forgot Password?", style = TextStyle(color = Color.Red))
                }
            }
            ButtonView(
                onClick = {},
                btnColor = ButtonDefaults.buttonColors(),
                text = "Login In",
                textStyle = TextStyle(Color.White, fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier
                        .width(100.dp),
                    thickness = 2.dp
                )
                Text(
                    text = "or login with",
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp)
                )
                Divider(
                    modifier = Modifier
                        .width(100.dp),
                    thickness = 2.dp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Button(
                    onClick = { },
                    modifier = Modifier
                        .width(160.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),

                    ) {
                    Image(
                        painter = painterResource(id = R.mipmap.ic_google),
                        contentDescription = null, modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(text = "Google", color = Color.Black)
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .width(160.dp),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.ic_facebook),
                        contentDescription = null, modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(text = "Facebook", color = Color.Black)
                }
            }
        }
    }
}