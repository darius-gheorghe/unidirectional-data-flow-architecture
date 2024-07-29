package com.example.udfArchitecture.composable.ui.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.udfArchitecture.composable.baseScreen.BaseScreen
import com.example.udfArchitecture.viewModelImpl.example.ExampleScreenAction
import com.example.udfArchitecture.viewModelImpl.example.ExampleScreenEffect
import com.example.udfArchitecture.viewModelImpl.example.ExampleScreenState
import com.example.udfArchitecture.viewModelImpl.example.ExampleScreenViewModel
import kotlinx.coroutines.flow.SharedFlow

object ExampleScreen :
    BaseScreen<ExampleScreenState, ExampleScreenAction, ExampleScreenEffect, ExampleScreenViewModel>() {

    @Composable
    override fun Screen(
        state: ExampleScreenState,
        effect: SharedFlow<ExampleScreenEffect>,
        processUiAction: (action: ExampleScreenAction) -> Unit
    ) {
        //We use LocalContext.current for getting resources
        val context = LocalContext.current

        when (state) {
            is ExampleScreenState.LoadingState -> {
                Box(
                    contentAlignment = Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }

            is ExampleScreenState.SuccessState -> {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = state.greetingMessage,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}