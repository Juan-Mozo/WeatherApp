package com.juanimozo.weatherapp.presentation.feature_login.search_city_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.weatherapp.presentation.city.CityItem
import com.juanimozo.weatherapp.presentation.feature_login.UserViewModel
import com.juanimozo.weatherapp.ui.theme.*

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

        // Search with gps
        Row(
            modifier = Modifier
                .padding(horizontal = Values.Padding.small)
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = LightGrey,
                onClick = { viewModel.searchCityByGeoPosition(navController)}
            ) {
                Row(
                    modifier = Modifier.padding(Values.Padding.medium),
                ) {
                    Icon(
                        modifier = Modifier.padding(horizontal = Values.Padding.medium),
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Search current location"
                    )
                    Text(
                        text = "Search with location",
                        style = TextStyle(
                            fontFamily = Fonts.QuickSandRegular,
                            fontSize = 20.sp,
                            color = DarkGreyTeal
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(Values.Spacer.large))

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
                    backgroundColor = MaterialTheme.weatherPalette.textFieldBackground,
                    unfocusedBorderColor = MaterialTheme.weatherPalette.textFieldUnfocusedBorderColor
                )
            )
        }

        Spacer(modifier = Modifier.height(Values.Spacer.medium))

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
                        modifier = Modifier
                            .padding(vertical = Values.Padding.medium)
                            .fillMaxWidth(0.75f),
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
        }
    }
}