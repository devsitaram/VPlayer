package com.edu.vplayer.features.presentation.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.edu.vplayer.features.domain.model.GoogleUserModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import kotlinx.coroutines.launch

class SignInGoogleViewModel(application: Application) : AndroidViewModel(application) {
    private var _userState = MutableLiveData<GoogleUserModel>()
    val googleUser: LiveData<GoogleUserModel> = _userState
    private var _loadingState = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loadingState

    init {
        checkSignedInUser(application.applicationContext)
    }

    fun fetchSingInUser(email: String?, name: String?) {
        _loadingState.value = true

        viewModelScope.launch {
            _userState.value = GoogleUserModel(
                email = email,
                name = name,
            )
        }
        _loadingState.value = false
    }

    private fun checkSignedInUser(applicationContext: Context) {
        _loadingState.value = true
        val gsa = GoogleSignIn.getLastSignedInAccount(applicationContext)
        Log.e("gsa" ,"gsa: $gsa")
        if (gsa != null) {
            _userState.value = GoogleUserModel(
                email = gsa.email,
                name = gsa.displayName,
            )
        }
        _loadingState.value = false
    }

    fun hideLoading() {
        _loadingState.value = false
    }

    fun showLoading() {
        _loadingState.value = true
    }

    @Suppress("UNCHECKED_CAST")
    class SignInGoogleViewModelFactory(
        private val application: Application
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SignInGoogleViewModel::class.java)) {
                return SignInGoogleViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}