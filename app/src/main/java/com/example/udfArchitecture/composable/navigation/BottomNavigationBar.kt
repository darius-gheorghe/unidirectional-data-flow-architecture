package com.example.udfArchitecture.composable.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.udfArchitecture.design.color.StyledThemeProvider
import com.example.udfArchitecture.navigation.bottomNavigation.BottomNavItem

@Composable
fun BottomNavigationBar(
    navController: NavController,
    action: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem.ExampleBottomNavItem,
        //BottomNavItem.SomeOtherBottomNavItem,
    )

    NavigationBar(
        containerColor = StyledThemeProvider.colors.surfaceLayer,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = StyledThemeProvider.colors.onSecondaryContainer,
                    unselectedTextColor = StyledThemeProvider.colors.onSurfaceVariant,
                    selectedTextColor = StyledThemeProvider.colors.onSurface,
                    unselectedIconColor = StyledThemeProvider.colors.onSurfaceVariant,
                    indicatorColor = StyledThemeProvider.colors.secondaryContainer,
                ),
                onClick = {
                    action(item)
                }
            )
        }
    }
}