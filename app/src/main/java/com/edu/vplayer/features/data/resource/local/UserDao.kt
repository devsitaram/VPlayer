package com.edu.vplayer.features.data.resource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: List<User?>)

    @Query("SELECT * FROM user_table")
    fun getAllData(): List<User>

    @Query("DELETE FROM user_table where id = :id")
    suspend fun deleteById(id: Int)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    //Profile Info
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserDetails(user: ProfileEntity?)
}

