package com.juanimozo.weatherapp.presentation.feature_forecast.animations

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.*

@Composable
 fun LoadingAnimation(
    animation: Int,
    modifier: Modifier = Modifier
 ) {
     var isAnimationPlaying by remember {
         mutableStateOf(true)
     }
     var animationSpeed by remember {
         mutableStateOf(1f)
     }
     val composition by rememberLottieComposition(
         LottieCompositionSpec.RawRes(animation)
     )

    val lottieAnimation by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isAnimationPlaying,
        speed = animationSpeed,
        restartOnPlay = true
    )

    LottieAnimation(composition, lottieAnimation, modifier)

 }