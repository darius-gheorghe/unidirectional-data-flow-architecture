package com.example.usersAppUDF.composable.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.usersAppUDF.navigation.UDFDestinations
import com.example.usersAppUDF.navigation.bottomNavigation.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UDFNavHost(
    navController: NavHostController,
    startRoute: String,
    action: (BottomNavItem) -> Unit
) {
    NavHost(navController = navController, startDestination = startRoute) {
        UDFDestinations.entries.forEach { destination ->
            composable(destination.route) {
                if (destination.hasBottomBar) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                navController = navController,
                                action = action
                            )
                        }
                    ) { padding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                        ) {
                            destination.content()
                        }
                    }
                } else {
                    destination.content()
                }
            }
        }
    }
}