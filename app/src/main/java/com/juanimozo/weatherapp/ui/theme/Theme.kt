package com.juanimozo.weatherapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = Brown,
    primaryVariant = LightGrey,
    secondary = GreyTeal,
    secondaryVariant = LightGreyTeal,
//    surface =
//    error =
//    onSecondary =
//    onBackground =
//    onSurface =
//    onError
    background = Color.White,
    onBackground = DarkGreyTeal,
    onPrimary = Beige
)

private val DarkColorPalette = darkColors(
    primary = Brown,
    primaryVariant = LightGrey,
    secondary = GreyTeal,
    secondaryVariant = LightGreyTeal,
    background = DarkGrey,
    onBackground = White,
    onPrimary = Beige
//    surface =
//    error =
//    onSecondary =
//    onBackground =
//    onSurface =
//    onError
)

@Composable
fun WeatherAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    if (darkTheme) {
        // Dark Theme
        MaterialTheme(
            colors = DarkColorPalette,
            typography = DarkTypography,
            shapes = Shapes,
            content = content
        )
    } else {
        // Light Theme
        MaterialTheme(
            colors = LightColorPalette,
            typography = LightTypography,
            shapes = Shapes,
            content = content
        )
    }
}