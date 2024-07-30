package com.example.udfArchitecture.design.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import com.example.design.color.StyledColors
import com.example.design.palettes.LightColorPalette

object StyledThemeProvider {
    val colors: StyledColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}

private val LocalColors = compositionLocalOf { LightColorPalette }