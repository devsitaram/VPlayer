package com.edu.vplayer.features.di

import com.edu.vplayer.features.domain.repository.ProfileRepository
import com.edu.vplayer.features.domain.repository.RegisterUserRepository
import com.edu.vplayer.features.domain.repository.SubjectRepository
import com.edu.vplayer.features.domain.repository.UserRepository
import com.edu.vplayer.features.domain.usecase.LoginUseCase
import com.edu.vplayer.features.domain.usecase.ProfileUseCase
import com.edu.vplayer.features.domain.usecase.RegisterUserUseCase
import com.edu.vplayer.features.domain.usecase.SubjectUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppDetails {
    @Singleton
    @Provides
    fun providesGetUser(userRepository: UserRepository): LoginUseCase{
        return LoginUseCase(userRepository)
    }
    @Singleton
    @Provides
    fun providesGetSubject(subjectRepository: SubjectRepository): SubjectUseCase{
        return SubjectUseCase(subjectRepository)
    }
    @Singleton
    @Provides
    fun provideGetProfileDetails(profileRepository: ProfileRepository): ProfileUseCase{
        return  ProfileUseCase(profileRepository)

    }
    @Singleton
    @Provides
    fun provideUsersDetails(registerUserRepository: RegisterUserRepository): RegisterUserUseCase {
        return RegisterUserUseCase(registerUserRepository)
    }
}