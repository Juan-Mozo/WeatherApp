package com.juanimozo.weatherapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

// Light Theme Text Styles
val LightTypography = Typography(
    h1 = TextStyle(
        fontFamily = Fonts.MontserratSemiBold,
        fontSize = 38.sp,
        color = DarkGreyTeal,
        letterSpacing = 1.5.sp
    ),
    h2 = TextStyle(
        fontFamily = Fonts.MontserratMedium,
        fontSize = 30.sp,
        color = GreyTeal,
        letterSpacing = 1.5.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Fonts.MontserratRegular,
        fontSize = 24.sp,
        color = Brown
    ),
    subtitle2 = TextStyle(
        fontFamily = Fonts.MontserratRegular,
        fontSize = 24.sp,
        color = Beige
    ),
    body1 = TextStyle(
        fontFamily = Fonts.QuickSandRegular,
        fontSize = 20.sp,
        color = DarkNavy
    ),
    body2 = TextStyle(
        fontFamily = Fonts.QuickSandRegular,
        fontSize = 14.sp,
        color = DarkNavySemiTransparent
    ),
    button = TextStyle(
        fontFamily = Fonts.QuickSandRegular,
        fontSize = 20.sp,
        color = Beige
    )
)

// Dark Theme Text Styles
val DarkTypography = Typography(
    h1 = TextStyle(
        fontFamily = Fonts.MontserratSemiBold,
        fontSize = 38.sp,
        color = LightGreyTeal
    ),
    h2 = TextStyle(
        fontFamily = Fonts.MontserratMedium,
        fontSize = 30.sp,
        color = Beige
    ),
    subtitle1 = TextStyle(
        fontFamily = Fonts.MontserratRegular,
        fontSize = 24.sp,
        color = Beige
    ),
    subtitle2 = TextStyle(
        fontFamily = Fonts.MontserratRegular,
        fontSize = 24.sp,
        color = LightGrey
    ),
    body1 = TextStyle(
        fontFamily = Fonts.QuickSandRegular,
        fontSize = 20.sp,
        color = Beige
    ),
    body2 = TextStyle(
        fontFamily = Fonts.QuickSandRegular,
        fontSize = 14.sp,
        color = BeigeSemiTransparent
    ),
    button = TextStyle(
        fontFamily = Fonts.QuickSandRegular,
        fontSize = 20.sp,
        color = Beige
    )
)