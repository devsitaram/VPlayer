//package com.edu.vplayer.features.data.resource.local
//
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import androidx.room.Update
//
//interface ProfileDao {
//
//
//    @Query("SELECT * FROM user_table")
//    fun getAllData(): List<ProfileEntity>
//    @Query("DELETE FROM user_table where id = :id")
//    suspend fun deleteById(id: Int)
//    @Update
//    suspend fun updateUser(profileEntity: ProfileEntity)
//
//    @Delete
//    suspend fun deleteUser(profileEntity: ProfileEntity)
//}
