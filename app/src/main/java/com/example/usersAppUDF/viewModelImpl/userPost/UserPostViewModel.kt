package com.example.usersAppUDF.viewModelImpl.userPost

import com.example.usersAppUDF.domain.Post
import com.example.usersAppUDF.navigation.NavigationManager
import com.example.usersAppUDF.viewModel.BaseViewModel
import javax.inject.Inject

class UserPostViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    interactor: UserPostInteractor
) : BaseViewModel<UserPostScreenState, UserPostScreenAction, UserPostScreenEffect, UserPostScreenResult> (
    initialUiState = UserPostScreenState.Loading,
    interactor = interactor
) {
    override suspend fun handleResult(
        previous: UserPostScreenState,
        result: UserPostScreenResult
    ): UserPostScreenState {
        return when (result) {
            is UserPostScreenResult.Success -> {
                UserPostScreenState.Success(postList = result.postList)
            }
        }
    }

}

sealed interface UserPostScreenState {
    data object Loading : UserPostScreenState
    data class Success(val postList: List<Post>) : UserPostScreenState
}
sealed interface UserPostScreenAction
sealed interface UserPostScreenEffect
sealed interface UserPostScreenResult {
    data class Success(val postList: List<Post>) : UserPostScreenResult
}