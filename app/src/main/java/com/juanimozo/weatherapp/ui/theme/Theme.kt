package com.juanimozo.weatherapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class WeatherPalette(
    val material: Colors,
    val cardBackground: Color,
    val unselectedColumnItem: Color,
    val textFieldBackground: Color,
    val textFieldUnfocusedBorderColor: Color
) {
    val primary: Color get() = material.primary
    val primaryVariant: Color get() = material.primaryVariant
    val secondary: Color get() = material.secondary
    val secondaryVariant: Color get() = material.secondaryVariant
    val background: Color get() = material.background
    val surface: Color get() = material.surface
    val error: Color get() = material.error
    val onPrimary: Color get() = material.onPrimary
    val onSecondary: Color get() = material.onSecondary
    val onBackground: Color get() = material.onBackground
    val onSurface: Color get() = material.onSurface
    val onError: Color get() = material.onError
    val isLight: Boolean get() = material.isLight
}

private val LightColorPalette = WeatherPalette(
    material = lightColors(
        primary = Brown,
        primaryVariant = LightGrey,
        secondary = GreyTeal,
        secondaryVariant = LightGreyTeal,
        background = Color.White,
        onBackground = DarkGreyTeal,
        onPrimary = Beige
    ),
    cardBackground = LightGreyTeal,
    unselectedColumnItem = LightGrey,
    textFieldBackground = LightGrey,
    textFieldUnfocusedBorderColor = GreyTeal
)

private val DarkColorPalette = WeatherPalette(
    material = darkColors(
        primary = Brown,
        primaryVariant = LightGrey,
        secondary = GreyTeal,
        secondaryVariant = LightGreyTeal,
        background = DarkGrey,
        onBackground = White,
        onPrimary = Beige
    ),
    cardBackground = DarkGreyTeal,
    unselectedColumnItem = DarkGreyTeal,
    textFieldBackground = DarkGreyTeal,
    textFieldUnfocusedBorderColor = GreyTeal
)

private val LocalColors = staticCompositionLocalOf { LightColorPalette }

@Composable
fun WeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) { DarkColorPalette } else { LightColorPalette }
    val typography = if (darkTheme) { DarkTypography } else { LightTypography }

    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
            colors = colors.material,
            typography = typography,
            shapes = Shapes,
            content = content
        )
    }
}

val MaterialTheme.weatherPalette: WeatherPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current