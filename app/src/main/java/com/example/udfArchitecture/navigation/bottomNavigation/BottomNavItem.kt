package com.example.udfArchitecture.navigation.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.udfArchitecture.navigation.UDFDestinations

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    data object ExampleBottomNavItem : BottomNavItem(
        route = UDFDestinations.Example.route,
        title = "Example",
        icon = Icons.Default.Home
    )
}