package com.example.usersAppUDF.api

import com.example.usersAppUDF.domain.User
import retrofit2.http.GET

interface UserListService {

    @GET("users")
    suspend fun getUsersList(): List<User>
}