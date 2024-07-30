package com.example.usersAppUDF.viewModelImpl.main

import com.example.usersAppUDF.navigation.UDFDestinations
import com.example.usersAppUDF.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    interactor: MainInteractor
) :
    BaseViewModel<MainScreenState, MainScreenAction, MainScreenEffect, MainScreenResult>(
        interactor = interactor,
        initialUiState = MainScreenState.Initial
    ) {

    override suspend fun handleResult(
        previous: MainScreenState,
        result: MainScreenResult
    ): MainScreenState {
        return when (result) {
            is MainScreenResult.Initial -> {
                MainScreenState.Initial
            }

            is MainScreenResult.NavigateWithDestination -> {
                emmitEffect(MainScreenEffect.NavigateWithDestination(result.destinations.route))
                previous
            }
            is MainScreenResult.NavigateWithNavBar -> {
                emmitEffect(MainScreenEffect.NavigateWithNavBar(result.destination))
                previous
            }
            is MainScreenResult.PopBackStack -> {
                emmitEffect(MainScreenEffect.PopBackStack)
                previous
            }
            is MainScreenResult.Error -> {
                MainScreenState.Error
            }
        }
    }
}

sealed interface MainScreenState {
    data object Initial : MainScreenState
    data object Error : MainScreenState
    // data object Logged : MainScreenState
    // data object NotLogged : MainScreenState
}

sealed interface MainScreenAction {
    data class BottomBarClick(var route: String) : MainScreenAction
}

sealed interface MainScreenEffect {
    data class NavigateWithDestination(val route: String) : MainScreenEffect
    data class NavigateWithNavBar(val route: String) : MainScreenEffect
    data object PopBackStack : MainScreenEffect
}

sealed interface MainScreenResult {
    data object Initial : MainScreenResult
    data object Error : MainScreenResult
    data class NavigateWithDestination(val destinations: UDFDestinations) : MainScreenResult
    data class NavigateWithNavBar(val destination: String) : MainScreenResult
    data object PopBackStack : MainScreenResult
}