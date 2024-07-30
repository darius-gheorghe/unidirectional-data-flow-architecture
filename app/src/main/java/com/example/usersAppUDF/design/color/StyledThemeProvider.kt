package com.example.usersAppUDF.design.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import com.example.usersAppUDF.design.palettes.LightColorPalette

object StyledThemeProvider {
    val colors: StyledThemeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}

private val LocalColors = compositionLocalOf { LightColorPalette }