package com.edu.vplayer.features.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.ColumnInfo
import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.domain.usecase.RegisterUserUseCase
import com.edu.vplayer.features.presentation.state.RegisterState
import com.edu.vplayer.features.presentation.state.UsersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUserUseCase: RegisterUserUseCase) :
    ViewModel() {
    private val _register = mutableStateOf(RegisterState())
    val register: State<RegisterState> get() = _register
    fun registerUser(name: String?, email: String?, password: String?){
        registerUserUseCase(name, email, password).onEach {
            when (it) {
                is Resource.Loading -> {
                    _register.value = RegisterState(isLoading = true)
                }

                is Resource.Success -> {
                    _register.value = RegisterState(isSuccess = it.data)
                }

                is Resource.Error -> {
                    _register.value = RegisterState(isError = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}