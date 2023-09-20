//package com.edu.vplayer.features.presentation.ui.screen
//
//import android.annotation.SuppressLint
//import android.app.Application
//import android.util.Log
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Popup
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavHostController
//import com.edu.vplayer.R
//import com.edu.vplayer.features.data.data_resource.remote.api.GoogleApiContract
//import com.edu.vplayer.features.domain.model.GoogleUserModel
//import com.edu.vplayer.features.presentation.ui.components.FullScreenLoaderComponent
//import com.edu.vplayer.features.presentation.ui.components.SignInGoogleButton
//import com.edu.vplayer.features.presentation.ui.navigation.Destinations
//import com.edu.vplayer.features.presentation.viewModel.SignInGoogleViewModel
//import com.google.android.gms.common.api.ApiException
//import com.squareup.moshi.Moshi
//
//
//@Composable
//fun AuthScreen(navController: NavHostController) {
//    val signInRequestCode = 1
//    val context = LocalContext.current
//
//    val mSignInViewModel: SignInGoogleViewModel = viewModel(
//        factory = SignInGoogleViewModel.SignInGoogleViewModelFactory(context.applicationContext as Application)
//    )
//
//    val state = mSignInViewModel.googleUser.observeAsState()
//    val user = state.value
//
//    val isError = rememberSaveable { mutableStateOf(false) }
//
//    val authResultLauncher = rememberLauncherForActivityResult(contract = GoogleApiContract()) { task ->
//            try {
//                val gsa = task?.getResult(ApiException::class.java)
//
//                if (gsa != null) {
//                    mSignInViewModel.fetchSingInUser(gsa.email, gsa.displayName)
//                } else {
//                    isError.value = true
//                }
//            } catch (e: ApiException) {
////                Timber.d("Error in AuthScreen%s", e.toString())
//                Log.d("Error in AuthScreen%s", e.toString())
//
//            }
//        }
//
//    AuthView(
//        onClick = { authResultLauncher.launch(signInRequestCode) },
//        isError = isError.value,
//        mSignInViewModel
//    )
//    // Strange issue after upgrading to latest version
////    if (mSignInViewModel.googleUser.value != null) {
////        LaunchedEffect(key1 = Unit) {
////            mSignInViewModel.hideLoading()
////            navController.navigate(
////                HomeScreenView(
////                    GoogleUserModel(
////                        email = user?.email,
////                        name = user?.name,
////                    )
////                )
////            ) {
////                popUpTo(ScreenList.SubjectScreen.route) {
////                    inclusive = true
////                }
////            }
////        }
////    }
//
//    user?.let {
//        mSignInViewModel.hideLoading()
//        val moshi = Moshi.Builder().build()
//        val jsonAdapter = moshi.adapter(GoogleUserModel::class.java)
//        val userJson = jsonAdapter.toJson(user)
//        navController.navigate(Destinations.Home.replace("{user}" ,userJson))
//        navController.navigate(Destinations.Home)
//    }
//}
//
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
// fun AuthView(
//    onClick: () -> Unit,
//    isError: Boolean = false,
//    mSignInViewModel: SignInGoogleViewModel
//) {
//    val state = mSignInViewModel.loading.observeAsState()
//    val isLoading = state.value
//
//    Scaffold {
//        if (isLoading == true && !isError) {
//            FullScreenLoaderComponent()
//        } else {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(24.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                Spacer(modifier = Modifier.weight(1F))
//                Spacer(modifier = Modifier.weight(1F))
//                SignInGoogleButton(onClick = {
//                    mSignInViewModel.showLoading()
//                    onClick()
//                })
//                Spacer(modifier = Modifier.weight(1F))
//                Text(
//                    text = stringResource(R.string.app_login_bottom),
//                    textAlign = TextAlign.Center,
//                )
//
//                when {
//                    isError -> {
//                        isError.let {
//                            Text(
//                                stringResource(R.string.auth_error_msg),
//                                style = MaterialTheme.typography.h6,
//                                color = MaterialTheme.colors.error
//                            )
//                            mSignInViewModel.hideLoading()
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
