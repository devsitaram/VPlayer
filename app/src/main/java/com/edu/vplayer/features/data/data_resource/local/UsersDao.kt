package com.edu.vplayer.features.data.data_resource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsersDao {

    @Insert
    suspend fun insertUser(users: Users)

    @Update
    suspend fun updateUser(users: Users)

    @Delete
    suspend fun deleteUser(users: Users)

    @Query("SELECT * FROM users_table")
    fun getAllData(): LiveData<Users>

    @Query("DELETE FROM users_table where id = :id")
    suspend fun deleteById(id: Int)
}