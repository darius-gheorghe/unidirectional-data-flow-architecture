package com.example.usersAppUDF.viewModelImpl.example

import com.example.usersAppUDF.navigation.NavigationManager
import com.example.usersAppUDF.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExampleScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    interactor: ExampleScreenInteractor
) : BaseViewModel<ExampleScreenState, ExampleScreenAction, ExampleScreenEffect, ExampleScreenResult>(
    interactor = interactor,
    initialUiState = ExampleScreenState.LoadingState
) {
    override suspend fun handleResult(
        previous: ExampleScreenState,
        result: ExampleScreenResult
    ): ExampleScreenState {
        return when (result) {
            is ExampleScreenResult.LoadingResult -> {
                previous
            }

            is ExampleScreenResult.SuccessResult -> {
                ExampleScreenState.SuccessState(greetingMessage = result.greetingMessage)
            }
        }
    }
}

sealed interface ExampleScreenState {
    data object LoadingState : ExampleScreenState
    data class SuccessState(val greetingMessage: String): ExampleScreenState
}

sealed interface ExampleScreenAction
sealed interface ExampleScreenEffect

sealed interface ExampleScreenResult {
    data object LoadingResult : ExampleScreenResult
    data class SuccessResult(val greetingMessage: String) : ExampleScreenResult
}