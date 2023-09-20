package com.edu.vplayer.features.presentation.viewModel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.vplayer.features.data.data_resource.common.Resource
import com.edu.vplayer.features.domain.usecase.LoginUseCase
import com.edu.vplayer.features.presentation.state.UsersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class LoginViewModel  @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _users = mutableStateOf(UsersState())
    val users: State<UsersState> get() = _users

    fun getUsers(email: String, password: String) {
        Log.e("Users: ", "User: $email, $password")
        loginUseCase(email, password).onEach {
            when (it) {
                is Resource.Loading -> {
                    _users.value = UsersState(isLoading = true)
                }

                is Resource.Success -> {
                    _users.value = UsersState(isData = it.data)
                }

                is Resource.Error -> {
                    _users.value = UsersState(isError = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}