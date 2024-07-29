package com.example.design.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color


class StyledColors(
    background: Color,
    surface: Color,
    surfaceLayer: Color,
    onSurface: Color,
    onSurfaceVariant: Color,
    disableState: Color,
    hint: Color,
    primary: Color,
    secondary: Color,
    secondaryContainer: Color,
    onSecondaryContainer: Color,
    outline: Color,
    outlineVariant: Color,
    shadow: Color,
    error: Color,
    val constantWhite: Color = Color.White
) {

    var background: Color by mutableStateOf(background)
        private set

    var surface: Color by mutableStateOf(surface)
        private set

    var surfaceLayer: Color by mutableStateOf(surfaceLayer)
        private set

    var onSurface: Color by mutableStateOf(onSurface)
        private set

    var onSurfaceVariant: Color by mutableStateOf(onSurfaceVariant)
        private set

    var disableState: Color by mutableStateOf(disableState)
        private set

    var hint: Color by mutableStateOf(hint)
        private set

    var primary: Color by mutableStateOf(primary)
        private set

    var secondary: Color by mutableStateOf(secondary)
        private set

    var secondaryContainer: Color by mutableStateOf(secondaryContainer)
        private set

    var onSecondaryContainer: Color by mutableStateOf(onSecondaryContainer)
        private set

    var outline: Color by mutableStateOf(outline)
        private set

    var outlineVariant: Color by mutableStateOf(outlineVariant)
        private set

    var shadow: Color by mutableStateOf(shadow)
        private set

    var error: Color by mutableStateOf(error)
        private set

}