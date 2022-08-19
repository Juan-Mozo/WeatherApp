package com.juanimozo.weatherapp.presentation.feature_forecast.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ForecastTopBar(
    city: String
) {
    TopAppBar (
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // ToDo:: -Forecast TopBar- *1* / Priority: M
                // Description: Add menu drawer
                Box(
                    // ToDo:: -Forecast TopBar- *2* / Priority: M
                    // Description: Add navigation to ManageLocation
                    modifier = Modifier, // .clickable()
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = city
                    )
                }
            }
        }
    )

}