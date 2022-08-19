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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.weatherapp.presentation.city.CityItem
import com.juanimozo.weatherapp.presentation.feature_login.UserViewModel
import com.juanimozo.weatherapp.presentation.feature_login.registration.RegistrationEvents
import com.juanimozo.weatherapp.ui.theme.Size

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
                .padding(top = Size.Padding.large),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "MANAGE CITIES",
                style = MaterialTheme.typography.h1
            )
        }

        Spacer(modifier = Modifier.height(Size.Spacer.large))

        Row(
            modifier = Modifier
                .padding(horizontal = Size.Padding.large)
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.searchCityByGeoPosition(navController)}
            ) {
                Box(
                    modifier = Modifier.padding(Size.Padding.medium),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(text = "Search with location")
                }
            }
        }

        Spacer(modifier = Modifier.height(Size.Spacer.medium))

        // Search city by name
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Size.Padding.medium),
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

        Spacer(modifier = Modifier.height(Size.Spacer.small))

        // Results
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
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
                        modifier = Modifier.padding(vertical = Size.Padding.small)
                    )
                }
            }
        }
    }
}