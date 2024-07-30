package com.example.usersAppUDF.repository

import com.example.usersAppUDF.domain.Post
import kotlinx.coroutines.flow.Flow

interface UserPostRepository {
    fun getUserPosts(userId: Long): Flow<List<Post>>
}