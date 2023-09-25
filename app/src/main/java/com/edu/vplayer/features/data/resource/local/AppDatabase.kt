package com.edu.vplayer.features.data.resource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.edu.vplayer.features.data.common.SubjectTypeConverter

@Database(
    entities = [User::class, ProfileEntity::class, SubjectEntity::class],
    version = 5,
    exportSchema = false
)
@TypeConverters(SubjectTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "User_DB"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance

            }
        }
    }
}