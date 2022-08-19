package com.juanimozo.weatherapp.presentation.city

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.juanimozo.weatherapp.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CityItem(cityName: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.height(50.dp),
        shape = Shapes.large,
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = 3.dp,
        onClick = onClick
    ) {
        Box(
            modifier = Modifier.padding(start = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = cityName)
        }
    }
}