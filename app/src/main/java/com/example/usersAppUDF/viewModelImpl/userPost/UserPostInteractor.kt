package com.example.usersAppUDF.viewModelImpl.userPost

import com.example.usersAppUDF.repository.UserPostRepository
import com.example.usersAppUDF.viewModel.BaseInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPostInteractor @Inject constructor(
    private val userPostRepository: UserPostRepository,
) : BaseInteractor<UserPostScreenAction, UserPostScreenResult> {
    override fun actionToResult(action: UserPostScreenAction): Flow<UserPostScreenResult> {
        TODO("Not yet implemented")
    }

    override fun initResults(): Flow<UserPostScreenResult> {
        return getUserPosts(0L)
    }

    private fun getUserPosts(userId: Long) =
        userPostRepository.getUserPosts(userId).map { UserPostScreenResult.Success(it) }
}