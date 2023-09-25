package com.edu.vplayer.features.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.vplayer.features.data.common.Resource
import com.edu.vplayer.features.data.resource.local.ProfileEntity
import com.edu.vplayer.features.domain.usecase.ProfileUseCase
import com.edu.vplayer.features.presentation.state.ProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val profileUseCase: ProfileUseCase) : ViewModel() {

    private val _profile = mutableStateOf(ProfileState())
    val profile: State<ProfileState> get() = _profile

    init {
        getProfileData()
    }
    private fun getProfileData() {
        profileUseCase().onEach {
            when (it) {

                is Resource.Loading -> {
                    _profile.value = ProfileState(isLoading = true)
                }

                is Resource.Success -> {
                    _profile.value = ProfileState(isData = it.data)
                }

                is Resource.Error -> {
                    _profile.value = ProfileState(isError = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

    fun insertUserDetails(profileEntity: ProfileEntity){
        profileUseCase(profileEntity).launchIn(viewModelScope)
    }
}