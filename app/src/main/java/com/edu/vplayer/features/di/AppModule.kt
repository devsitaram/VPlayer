package com.edu.vplayer.features.di

import com.edu.vplayer.features.data.data_resource.remote.api.ApiConstants
import com.edu.vplayer.features.data.data_resource.remote.api.ApiService
import com.edu.vplayer.features.data.data_resource.remote.repository.SubjectRepositoryImpl
import com.edu.vplayer.features.data.data_resource.remote.repository.UsersRepoImpl
import com.edu.vplayer.features.domain.repository.SubjectRepository
import com.edu.vplayer.features.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
        return UsersRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun  provideSubjectAPi(apiService: ApiService): SubjectRepository{
        return  SubjectRepositoryImpl(apiService)

    }

}
