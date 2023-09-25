package com.edu.vplayer.features.data.resource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.edu.vplayer.features.data.resource.remote.api.model.SubjectItems

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
    suspend fun insertUserDetails(profileEntity: ProfileEntity?)

    @Upsert
    suspend fun insertSubjectDetails(subject: List<SubjectEntity>)

    @Query("SELECT * FROM Subject_table")
    suspend fun getSubjectDetails(): List<SubjectItems>



}

