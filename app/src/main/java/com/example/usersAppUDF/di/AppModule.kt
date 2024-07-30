package com.example.usersAppUDF.di

import com.example.usersAppUDF.api.RetrofitUserInstance
import com.example.usersAppUDF.api.UserListService
import com.example.usersAppUDF.api.UserPostService
import com.example.usersAppUDF.repository.UserPostRepository
import com.example.usersAppUDF.repository.UserPostRepositoryImpl
import com.example.usersAppUDF.repository.UsersRepository
import com.example.usersAppUDF.navigation.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesNavigationManager(): NavigationManager = NavigationManager()

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RetrofitUserInstance.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserListService(retrofit: Retrofit): UserListService =
        retrofit.create(UserListService::class.java)

    @Provides
    @Singleton
    fun provideUserPostService(retrofit: Retrofit): UserPostService =
        retrofit.create(UserPostService::class.java)

    @Provides
    @Singleton
    fun provideUsersRepository(userListService: UserListService): UsersRepository =
        UsersRepository(userListService)

    @Provides
    @Singleton
    fun provideUserPostRepository(userPostService: UserPostService): UserPostRepository =
        UserPostRepositoryImpl(userPostService)
}