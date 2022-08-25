package com.juanimozo.weatherapp.presentation.feature_login.search_city_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.weatherapp.presentation.city.CityItem
import com.juanimozo.weatherapp.presentation.feature_login.UserViewModel
import com.juanimozo.weatherapp.ui.theme.Values

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchCityScreen(
    navController: NavController
) {

    val viewModel: UserViewModel = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Values.Padding.large),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "MANAGE CITIES",
                style = MaterialTheme.typography.h1
            )
        }

        Spacer(modifier = Modifier.height(Values.Spacer.large))

        Row(
            modifier = Modifier
                .padding(horizontal = Values.Padding.large)
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.searchCityByGeoPosition(navController)}
            ) {
                Box(
                    modifier = Modifier.padding(Values.Padding.medium),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(text = "Search with location")
                }
            }
        }

        Spacer(modifier = Modifier.height(Values.Spacer.medium))

        // Search city by name
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Values.Padding.medium),
                value = viewModel.cityState.value.searchQuery,
                onValueChange = { query ->
                    viewModel.searchCityByName(query) },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
                label = {
                    Text(text = "Search city...") },
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    unfocusedBorderColor = MaterialTheme.colors.secondary
                )
            )
        }

        Spacer(modifier = Modifier.height(Values.Spacer.small))

        // Results
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // ToDo:: -1- *FIX* / Priority: HIGH
            // Description: Doesn't show
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(viewModel.cityState.value.cities) { city ->
                    CityItem(
                        cityName = city.LocalizedName,
                        onClick = {
                            viewModel.updateCurrentCity(city, navController)
                        }
                    )
                    Divider(
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(vertical = Values.Padding.small)
                    )
                }
            }
        }
    }
}