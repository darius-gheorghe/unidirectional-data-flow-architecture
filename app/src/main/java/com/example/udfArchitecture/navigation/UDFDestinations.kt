package com.example.udfArchitecture.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.udfArchitecture.composable.ui.exampleScreen.ExampleScreen

enum class UDFDestinations(
    val route: String,
    val hasBottom: Boolean = false,
    val content: @Composable () -> Unit
) {
    // Bottom Nav Screens
    Example(
        route = "example",
        hasBottom = false,
        content = { ExampleScreen.Content(hiltViewModel()) }),
}