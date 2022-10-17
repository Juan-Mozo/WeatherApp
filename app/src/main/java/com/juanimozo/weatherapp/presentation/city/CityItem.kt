package com.juanimozo.weatherapp.presentation.city

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.juanimozo.weatherapp.domain.model.CityModel
import com.juanimozo.weatherapp.ui.theme.Shapes
import com.juanimozo.weatherapp.ui.theme.Values
import com.juanimozo.weatherapp.ui.theme.weatherPalette

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CityItem(city: CityModel, onClick: () -> Unit) {
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
            modifier = Modifier.padding(horizontal = Values.Padding.small, vertical = Values.Padding.large)
        ) {
            Text(
                text = "${city.localizedName}, ${city.regionLocalizedName} - ${city.countryLocalizedName}",
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                textAlign = TextAlign.Center
            )
        }
    }
}