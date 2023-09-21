//package com.edu.vplayer.features.presentation.viewModel
//
//import android.content.Context
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.edu.vplayer.features.data.data_resource.local.Users
//import com.edu.vplayer.features.data.repository_impl.UsersRepository
//import kotlinx.coroutines.launch
//
//class UsersViewModel (context: Context): ViewModel(){
//
//    private val usersRepository : UsersRepository = UsersRepository(context)
//        fun getALlUsers(): LiveData<Users>{
//        return usersRepository.readAllUsers
//    }
//
//    fun insertUsers(users: Users){
//        viewModelScope.launch {
//            usersRepository.insertUser(users = users)
//        }
//    }
//
//    fun deleteById(id: Int){
//        viewModelScope.launch {
//            usersRepository.deleteById(id)
//        }
//    }
//
//}