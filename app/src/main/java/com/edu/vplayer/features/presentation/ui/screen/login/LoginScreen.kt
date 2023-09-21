package com.edu.vplayer.features.presentation.ui.screen.login

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.edu.vplayer.R
import com.edu.vplayer.features.data.common.util.isValidEmail
import com.edu.vplayer.features.data.resource.remote.api.GoogleApiContract
import com.edu.vplayer.features.presentation.ui.components.ButtonView
import com.edu.vplayer.features.presentation.ui.components.ClickableTextView
import com.edu.vplayer.features.presentation.ui.components.FullScreenLoaderComponent
import com.edu.vplayer.features.presentation.ui.components.IconView
import com.edu.vplayer.features.presentation.ui.components.InputTextFieldView
import com.edu.vplayer.features.presentation.ui.components.PainterImageView
import com.edu.vplayer.features.presentation.ui.components.PasswordTextFieldView
import com.edu.vplayer.features.presentation.ui.components.SignInGoogleButton
import com.edu.vplayer.features.presentation.ui.components.TextView
import com.edu.vplayer.features.presentation.ui.navigation.ScreenList
import com.edu.vplayer.features.presentation.viewModel.LoginViewModel
import com.edu.vplayer.features.presentation.viewModel.SignInGoogleViewModel
import com.google.android.gms.common.api.ApiException
import androidx.compose.material3.Text as Text

@Composable
fun LoginViewScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val getSharedPreferences = context.getSharedPreferences("my_preferences", ComponentActivity.MODE_PRIVATE)
//    val usersRepository = UsersRepository(context)
    val result = loginViewModel.users.value
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val checked = remember { mutableStateOf(false) }
    var isEmailEmpty by remember { mutableStateOf(false) }
    var isPasswordEmpty by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }

    val mSignInViewModel: SignInGoogleViewModel = viewModel(
        factory = SignInGoogleViewModel.SignInGoogleViewModelFactory(context.applicationContext as Application)
    )
//    val state = mSignInViewModel.googleUser.observeAsState()
    val isLoading = mSignInViewModel.loading.observeAsState()
    val isError = rememberSaveable { mutableStateOf(false) }
    val authResultLauncher =
        rememberLauncherForActivityResult(contract = GoogleApiContract()) { task ->
            try {
                val gsa = task?.getResult(ApiException::class.java)

                if (gsa != null) {
                    mSignInViewModel.fetchSingInUser(gsa.email, gsa.displayName)
                } else {
                    isError.value = true
                }
            } catch (e: ApiException) {
            }
        }
    //button onclick
    val onClick: () -> Unit = {
        isEmailEmpty = email.isEmpty()
        isPasswordEmpty = password.isEmpty()
        if (email.isNotEmpty() && password.isNotEmpty()) {
            if (isValidEmail(email)) {
                Toast.makeText(context, "Email is valid", Toast.LENGTH_SHORT).show()
                Log.e("Email:", "Email is valid")
            } else {
                Toast.makeText(context, "Email is not valid", Toast.LENGTH_SHORT).show()
            }
            loginViewModel.getUsers(email, password)
            if (result.isData?.success == true) {
                isSuccess = true
                navController.navigate(ScreenList.SubjectScreen.route)
                val editSharedPreferences = getSharedPreferences.edit()
                editSharedPreferences.putString("login_screen","${result.isData.result?.accessToken}").apply()
            } else {
                isSuccess = false
            }
        }
    }

    if (result.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (result.isError.isNotEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            // show error
            Text(text = result.isError, color = Color.Red)

        }
    }

    if (isLoading.value == true && result.isLoading) {
        FullScreenLoaderComponent()
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PainterImageView(painterResource(id = R.mipmap.img))
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
                isEmpty = isEmailEmpty,
                invalidMessage = "The email is empty!",
                errorColor = Color.Red,
                leadingIcon = { IconView(imageVector = Icons.Default.Email) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            PasswordTextFieldView(
                value = password,
                onValueChange = { password = it },
                label = "Enter Text",
                placeholder = "Enter Password",
                textStyle = TextStyle(),
                isEmpty = isPasswordEmpty,
                invalidMessage = "The password is empty!",
                leadingIcon = { IconView(imageVector = Icons.Default.Lock) },
                errorColor = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checked.value,
                        onCheckedChange = { isChecked -> checked.value = isChecked }
                    )
                    TextView(text = "Remember Password")
                }
                ClickableTextView(
                    text = AnnotatedString("Forgot Password?"),
                    style = TextStyle(color = Color.Red),
                    onClick = { navController.navigate(ScreenList.ForgotScreen.route) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            ButtonView(
                onClick = { onClick()
//                    usersRepository.readAllUser

                          },
                btnColor = ButtonDefaults.buttonColors(Color.Blue),
                text = "Login In",
                textStyle = TextStyle(Color.White, fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextView(text = "Don't have an account?", color = Color.Gray)
                Spacer(modifier = Modifier.padding(5.dp))
                ClickableTextView(
                    text = AnnotatedString("Register Now"),
                    style = TextStyle(color = Color.Blue),
                    onClick = { navController.navigate(ScreenList.RegisterScreen.route) },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier
                        .width(140.dp),
                    thickness = 2.dp
                )
                Text(
                    text = "or login with",
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp)
                )
                Divider(
                    modifier = Modifier
                        .width(140.dp),
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
                SignInGoogleButton(
                    onClick = {
                        mSignInViewModel.showLoading()
                        authResultLauncher.launch(1)
                    }
                )
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
    if (isSuccess) {
        Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
    }
}



