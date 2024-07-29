package com.example.udfArchitecture.composable.ui.main

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.example.udfArchitecture.composable.baseScreen.BaseScreen
import com.example.udfArchitecture.composable.navigation.UDFNavHost
import com.example.udfArchitecture.navigation.UDFDestinations
import com.example.udfArchitecture.viewModelImpl.main.MainScreenAction
import com.example.udfArchitecture.viewModelImpl.main.MainScreenEffect
import com.example.udfArchitecture.viewModelImpl.main.MainScreenState
import com.example.udfArchitecture.viewModelImpl.main.MainViewModel
import kotlinx.coroutines.flow.SharedFlow

object MainScreen :
    BaseScreen<MainScreenState, MainScreenAction, MainScreenEffect, MainViewModel>() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    override fun Screen(
        state: MainScreenState,
        effect: SharedFlow<MainScreenEffect>,
        processUiAction: (action: MainScreenAction) -> Unit,
    ) {
        val navController = rememberNavController()
        val startRoute = when (state) {
            is MainScreenState.Initial -> UDFDestinations.Example.route
            is MainScreenState.Error -> UDFDestinations.Error.route
        }

        UDFNavHost(
            navController = navController,
            startRoute = startRoute,
            action = {
                processUiAction(MainScreenAction.BottomBarClick(it.route))
            }
        )

        LaunchedEffect(Unit) {
            effect.collect {
                when (it) {
                    is MainScreenEffect.NavigateWithDestination -> {
                        navController.popBackStack(it.route, true)
                        navController.navigate(it.route)
                    }

                    is MainScreenEffect.NavigateWithNavBar -> {
                        when (it.route) {
                            UDFDestinations.Example.route -> navController.popBackStack()
                            else -> {
                                navController.navigate(it.route) {
                                    popUpTo(UDFDestinations.Example.route)
                                }
                            }
                        }
                    }

                    is MainScreenEffect.PopBackStack -> {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}