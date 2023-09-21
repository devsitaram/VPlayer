package com.edu.vplayer.features.di

import android.content.Context
import androidx.room.Room
import com.edu.vplayer.features.data.repository_impl.ProfileRepositoryImpl
import com.edu.vplayer.features.data.repository_impl.RegisterUsersRepositoryImpl
import com.edu.vplayer.features.data.resource.remote.api.ApiConstants
import com.edu.vplayer.features.data.resource.remote.api.ApiService
import com.edu.vplayer.features.data.repository_impl.SubjectRepositoryImpl
import com.edu.vplayer.features.data.repository_impl.UserRepoImpl
import com.edu.vplayer.features.data.resource.local.AppDatabase
import com.edu.vplayer.features.data.resource.local.AppDatabase.Companion.getInstance
import com.edu.vplayer.features.data.resource.local.UserDao
import com.edu.vplayer.features.domain.repository.ProfileRepository
import com.edu.vplayer.features.domain.repository.RegisterUserRepository
import com.edu.vplayer.features.domain.repository.SubjectRepository
import com.edu.vplayer.features.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideDatabaseInstance(@ApplicationContext context: Context): UserDao {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "User_DB"
        ).build().usersDao()
    }

    @Provides
    @Singleton
    fun providesDao(userDao: UserDao): RegisterUserRepository {
        return RegisterUsersRepositoryImpl(userDao)
    }

    //
    @Provides
    @Singleton
    fun provideRetrofit(): ApiService {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserApi(apiService: ApiService): UserRepository {
        return UserRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideSubjectAPi(apiService: ApiService): SubjectRepository {
        return SubjectRepositoryImpl(apiService)
    }


    @Singleton
    @Provides
    fun provideProfileDetails(apiService: ApiService): ProfileRepository {
        return ProfileRepositoryImpl(apiService)
    }

}
