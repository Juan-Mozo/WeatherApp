package com.juanimozo.weatherapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

// ToDo:: -1- *Project* / Priority: L
// Description: add letter spacing

// Light Theme Text Styles
val LightTypography = Typography(
    h1 = TextStyle(
        fontFamily = Fonts.MontserratSemiBold,
        fontSize = 32.sp,
        color = DarkGreyTeal
    ),
    h2 = TextStyle(
        fontFamily = Fonts.MontserratMedium,
        fontSize = 26.sp,
        color = GreyTeal
    ),
    subtitle1 = TextStyle(
        fontFamily = Fonts.MontserratRegular,
        fontSize = 20.sp,
        color = Brown
    ),
    subtitle2 = TextStyle(
        fontFamily = Fonts.MontserratRegular,
        fontSize = 20.sp,
        color = Beige
    ),
    body1 = TextStyle(
        fontFamily = Fonts.QuickSandRegular,
        fontSize = 16.sp,
        color = DarkNavy
    ),
    button = TextStyle(
        fontFamily = Fonts.QuickSandRegular,
        fontSize = 16.sp,
        color = Beige
    )
)

// Dark Theme Text Styles
val DarkTypography = Typography(
    h1 = TextStyle(
        fontFamily = Fonts.MontserratSemiBold,
        fontSize = 32.sp,
        color = Brown
    ),
    h2 = TextStyle(
        fontFamily = Fonts.MontserratMedium,
        fontSize = 26.sp,
        color = Beige
    ),
    subtitle1 = TextStyle(
        fontFamily = Fonts.MontserratRegular,
        fontSize = 20.sp,
        color = Beige
    ),
    subtitle2 = TextStyle(
        fontFamily = Fonts.MontserratRegular,
        fontSize = 20.sp,
        color = Beige
    ),
    body1 = TextStyle(
        fontFamily = Fonts.QuickSandRegular,
        fontSize = 16.sp,
        color = Beige
    ),
    button = TextStyle(
        fontFamily = Fonts.QuickSandRegular,
        fontSize = 16.sp,
        color = Beige
    )
)