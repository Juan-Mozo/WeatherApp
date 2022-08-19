package com.juanimozo.weatherapp.presentation.feature_login.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.juanimozo.core_util.language.Language
import com.juanimozo.weatherapp.ui.theme.Size

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LanguageItem(language: Language, onSelectCard: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = Size.Padding.large)
            .fillMaxWidth()
            .height(Size.Card.languageCardHeight),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        onClick = onSelectCard
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(Size.Padding.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = language.translatedName,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Composable
fun SelectedLanguageItem(language: Language) {
    // Card with selected language
    Card(
        modifier = Modifier
            .padding(horizontal = Size.Padding.large)
            .fillMaxWidth()
            .height(Size.Card.languageCardHeight),
        backgroundColor = MaterialTheme.colors.secondary,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(Size.Padding.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = language.translatedName,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}