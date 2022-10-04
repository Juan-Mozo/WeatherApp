package com.juanimozo.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.juanimozo.weatherapp.ui.theme.Values
import com.juanimozo.weatherapp.ui.theme.weatherPalette
import com.juanimozo.weatherapp.util.language.Language

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColumnItem(title: String, onSelectCard: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = Values.Padding.large)
            .fillMaxWidth()
            .height(Values.Card.languageCardHeight),
        backgroundColor = MaterialTheme.weatherPalette.unselectedColumnItem,
        onClick = onSelectCard
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(Values.Padding.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Composable
fun SelectedColumnItem(title: String) {
    // Card with selected language
    Card(
        modifier = Modifier
            .padding(horizontal = Values.Padding.large)
            .fillMaxWidth()
            .height(Values.Card.languageCardHeight),
        backgroundColor = MaterialTheme.colors.secondary,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(Values.Padding.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}