package com.edu.vplayer.features.presentation.ui.screen.register

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.edu.vplayer.R
import com.edu.vplayer.features.presentation.ui.components.ButtonView
import com.edu.vplayer.features.presentation.ui.components.IconView
import com.edu.vplayer.features.presentation.ui.components.InputTextFieldView
import com.edu.vplayer.features.presentation.ui.components.PainterImageView
import com.edu.vplayer.features.presentation.ui.components.PasswordTextFieldView
import com.edu.vplayer.features.presentation.ui.components.TextView
import com.edu.vplayer.features.presentation.ui.navigation.ScreenList
import com.edu.vplayer.features.presentation.viewModel.RegisterViewModel


@Composable
fun RegisterViewScreen(
    navHostController: NavHostController,
    viewModel: RegisterViewModel = hiltViewModel()
) {

val context = LocalContext.current

    val registerUser = viewModel.register

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isNameEmpty by remember { mutableStateOf(false) }
    var isEmailEmpty by remember { mutableStateOf(false) }
    var isPasswordEmpty by remember { mutableStateOf(false) }

    val onClick: () -> Unit = {
        if (name.isNotEmpty() || email.isNotEmpty() || password.isNotEmpty()) {
            viewModel.registerUser(name, email, password)
            if (registerUser.value.isSuccess == true){
                Toast.makeText(context, "Register Success", Toast.LENGTH_SHORT).show()
                navHostController.navigate(ScreenList.LoginScreen.route)
            } else {
                Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    if (registerUser.value.isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (registerUser.value.isError.isNotEmpty()){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            TextView(text = registerUser.value.isError)
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            ) {
            IconButton(onClick = { navHostController.navigate(ScreenList.LoginScreen.route) }) {
                IconView(imageVector = Icons.Default.ArrowBack)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                PainterImageView(painterResource(id = R.mipmap.ic_register))
                Spacer(modifier = Modifier.padding(5.dp))
                TextView(
                    text = "Create an Account",
                    style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Gray),
                    fontSize = 20.sp,
                )

            }
            InputTextFieldView(
                value = name,
                onValueChange = { name = it },
                label = "",
                placeholder = "Enter Name",
                textStyle = TextStyle(),
                isError = isNameEmpty,
                invalidMessage = "Name Text field is Empty!",
                errorColor = Color.Red,
                leadingIcon = { IconView(imageVector = Icons.Default.Person) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
            InputTextFieldView(
                value = email,
                onValueChange = { email = it },
                label = "",
                placeholder = "Enter Email",
                textStyle = TextStyle(),
                isError = isEmailEmpty,
                invalidMessage = "Email Text field is Empty!",
                errorColor = Color.Red,
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
                isEmpty = isPasswordEmpty,
                invalidMessage = "password Text field is Empty!",
                errorColor = Color.Red,
                leadingIcon = { IconView(imageVector = Icons.Default.Lock) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            ButtonView(
                onClick = {
                    isNameEmpty = name.isEmpty()
                    isEmailEmpty = email.isEmpty()
                    isPasswordEmpty = password.isEmpty()
                    onClick()
                },
                btnColor = ButtonDefaults.buttonColors(Color.Blue),
                text = "Register now",
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
                    text = "or register with",
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