package com.example.udfArchitecture.viewModelImpl.main

import com.example.udfArchitecture.navigation.NavigationCommands
import com.example.udfArchitecture.navigation.NavigationManager
import com.example.udfArchitecture.viewModel.BaseInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

class MainInteractor @Inject constructor(
    //private val authRepository: AuthenticationRepository,
    private val navigationManager: NavigationManager
) : BaseInteractor<MainScreenAction, MainScreenResult> {

    override fun actionToResult(action: MainScreenAction): Flow<MainScreenResult> {
//        return when (action) {
//            is MainScreenAction.BottomBarClick -> {
//                flowOf(MainScreenResult.NavigateWithNavBar(action.route))
//            }
//        }
        TODO("Not yet implemented")
    }

    override fun initResults(): Flow<MainScreenResult> {
//        val userStatusFlow = authRepository.observeUserState.map {
//            when (it) {
//                true ->  LoggedIn
//                false -> NotLoggedIn
//            }
//        }

        val userStatusFlow = flowOf(MainScreenResult.Initial)

        val navigationFlow = navigationManager.navigateCommand.map {
            when (it) {
                is NavigationCommands.NavigateCommand -> MainScreenResult.NavigateWithDestination(it.directions)
                is NavigationCommands.PopBackStackCommand -> MainScreenResult.PopBackStack
            }
        }
        return merge(userStatusFlow, navigationFlow)
    }
}