package com.juanimozo.weatherapp.presentation.feature_login.configuration.language

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.weatherapp.R
import com.juanimozo.weatherapp.navigation.Screens
import com.juanimozo.weatherapp.presentation.feature_login.UserViewModel
import com.juanimozo.weatherapp.presentation.feature_login.configuration.ConfigurationEvents
import com.juanimozo.weatherapp.ui.components.ColumnItem
import com.juanimozo.weatherapp.ui.components.SelectedColumnItem
import com.juanimozo.weatherapp.ui.components.navigation_drawer.AppBar
import com.juanimozo.weatherapp.ui.theme.Values
import com.juanimozo.weatherapp.util.language.Language

@Composable
fun SelectLanguageScreen(
    navController: NavController
) {

    val viewModel: UserViewModel = hiltViewModel()
    val currentConfiguration = viewModel.configurationState.value.language

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationClick = {
                    navController.popBackStack()
                },
                title = "",
                icon = Icons.Default.ArrowBack
            )
        }
    ) { scaffoldPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(scaffoldPadding),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            // Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.select_language_title),
                    style = MaterialTheme.typography.h1
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                LazyColumn() {
                    items(Language.languagesList) { language ->
                        // Check current Language
                        if (language == currentConfiguration) {
                            SelectedColumnItem(title = language.translatedName)
                        } else {
                            ColumnItem(
                                title = language.translatedName,
                                onSelectCard = {
                                    viewModel.onConfigurationEvent(ConfigurationEvents.SelectLanguage(language))
                                }
                            )
                        }
                        Spacer(modifier = Modifier.height(Values.Spacer.medium))
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.size(width = 150.dp, height = 50.dp),
                    onClick = { viewModel.updateUnit(navController) }
                ) {
                    Text(
                        text = stringResource(id = R.string.save_button_text),
                        style = MaterialTheme.typography.button
                    )
                }
            }

        }
    }
}