package com.juanimozo.weatherapp.presentation.feature_login.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.juanimozo.weatherapp.util.language.Language
import com.juanimozo.weatherapp.R
import com.juanimozo.weatherapp.presentation.feature_login.UserViewModel
import com.juanimozo.weatherapp.ui.components.ColumnItem
import com.juanimozo.weatherapp.ui.components.SelectedColumnItem
import com.juanimozo.weatherapp.ui.theme.*

@Composable
fun RegistrationScreen(navController: NavController) {

    val viewModel: UserViewModel = hiltViewModel()

    Column (modifier = Modifier.fillMaxSize()) {

        // Title
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.registration_header),
                    contentDescription = "A colourful cartoon style image of a park",
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Values.Padding.small),
                contentAlignment = Alignment.TopCenter
            ) {
                Text (
                    modifier = Modifier.padding(top = Values.Padding.medium),
                    text = "Sign Up",
                    style = TextStyle(
                        fontFamily = Fonts.MontserratSemiBold,
                        fontSize = 42.sp,
                        color = White
                    ),
                )
            }
        }

        // Insert user name
        Column (
            modifier = Modifier
                .padding(vertical = Values.Padding.medium)
                .fillMaxWidth()
                .fillMaxHeight(0.2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier.padding(bottom = Values.Padding.small),
                text = "Name",
                style = MaterialTheme.typography.h2
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Values.Padding.medium),
                value = viewModel.registrationState.value.userName,
                onValueChange = { query -> viewModel.onRegistrationEvent(RegistrationEvents.UpdateNameField(query)) },
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Person") },
                label = { Text(text = "Insert your name") },
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = MaterialTheme.weatherPalette.textFieldBackground,
                    unfocusedBorderColor = MaterialTheme.weatherPalette.textFieldUnfocusedBorderColor
                )
            )
        }

        // List of languages to select
        Column (
            modifier = Modifier
                .padding(vertical = Values.Padding.medium)
                .fillMaxWidth()
                .fillMaxHeight(0.75f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier.padding(bottom = Values.Padding.medium),
                text = "Language",
                style = MaterialTheme.typography.h2
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(Language.languagesList) { language ->
                    // Check whether language is already selected
                    if (language == viewModel.registrationState.value.selectedLanguage) {
                        SelectedColumnItem(title = language.translatedName)
                    } else {
                        ColumnItem(
                            title = language.translatedName,
                            onSelectCard = { viewModel.onRegistrationEvent(RegistrationEvents.SelectLanguage(language)) }
                        )
                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(vertical = Values.Padding.small),
                        color = MaterialTheme.colors.primary
                    )
                }
            }
        }

        // Submit registration
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.size(width = 150.dp, height = 50.dp),
                onClick = {
                    // Submit new account to database and navigate to SearchCityScreen
                    viewModel.createAccount(navController)
                }
            ) {
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewRegistrationScreen() {
    RegistrationScreen(navController = rememberNavController())
}