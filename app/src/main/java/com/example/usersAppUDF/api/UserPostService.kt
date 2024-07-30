package com.example.usersAppUDF.api

import com.example.usersAppUDF.domain.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface UserPostService {
    @GET("users/{userId}/posts")
    suspend fun getUserPosts(@Path("userId") userId: Long): List<Post>
}