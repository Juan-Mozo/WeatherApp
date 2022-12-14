package com.juanimozo.weatherapp.presentation.feature_login.search_city_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.weatherapp.R
import com.juanimozo.weatherapp.presentation.city.CityItem
import com.juanimozo.weatherapp.presentation.feature_login.UserViewModel
import com.juanimozo.weatherapp.ui.theme.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchCityScreen(
    navController: NavController
) {

    val viewModel: UserViewModel = hiltViewModel()

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            com.juanimozo.weatherapp.ui.components.navigation_drawer.AppBar(
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
                    text = stringResource(id = R.string.manage_cities_title),
                    style = MaterialTheme.typography.h1
                )
            }

            Spacer(modifier = Modifier.height(Values.Spacer.large))

            // Search with location
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
                        modifier = Modifier.padding(Values.Padding.small),
                    ) {
                        Icon(
                            modifier = Modifier,
                            imageVector = Icons.Default.LocationOn,
                            tint = DarkNavy,
                            contentDescription = "Search current location"
                        )
                        Text(
                            text = stringResource(id = R.string.search_with_location_title),
                            style = TextStyle(
                                fontFamily = Fonts.QuickSandRegular,
                                fontSize = 20.sp,
                                color = DarkGreyTeal
                            ),
                            textAlign = TextAlign.Center
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
                        Text(text = stringResource(id = R.string.search_city_textfield_label)) },
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
                            city = city,
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
}