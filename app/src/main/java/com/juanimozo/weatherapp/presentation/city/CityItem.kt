package com.juanimozo.weatherapp.presentation.city

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.juanimozo.weatherapp.ui.theme.Shapes
import com.juanimozo.weatherapp.ui.theme.Values
import com.juanimozo.weatherapp.ui.theme.weatherPalette

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CityItem(cityName: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = Values.Padding.medium)
            .fillMaxWidth(),
        shape = Shapes.medium,
        backgroundColor = MaterialTheme.weatherPalette.unselectedColumnItem,
        elevation = 3.dp,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = cityName,
                style = MaterialTheme.typography.body1
            )
        }
    }
}