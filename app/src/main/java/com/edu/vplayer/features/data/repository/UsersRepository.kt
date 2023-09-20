//package com.edu.vplayer.features.data.repository
//
//import android.app.Application
//import android.content.Context
//import androidx.lifecycle.LiveData
//import com.edu.vplayer.features.data.data_resource.local.AppDatabase
//import com.edu.vplayer.features.data.data_resource.local.Users
//import com.edu.vplayer.features.data.data_resource.local.UsersDao
//
//open class UsersRepository(context: Context) {
//    private  var usersDao: UsersDao
//
//    init {
//        val database = AppDatabase.getDatabase(context)
//        usersDao = database.usersDao()
//    }
//
//    val readAllUsers : LiveData<Users> = usersDao.getAllData()
//    suspend fun insertUser(users: Users){
//        usersDao.insertUser(users)
//    }
//
//    suspend fun updateUser(users: Users){
//        usersDao.updateUser(users)
//    }
//
//    suspend fun deleteUser(users: Users){
//        usersDao.deleteUser(users)
//    }
//
//    suspend fun deleteById(id: Int){
//        usersDao.deleteById(id)
//    }
//}