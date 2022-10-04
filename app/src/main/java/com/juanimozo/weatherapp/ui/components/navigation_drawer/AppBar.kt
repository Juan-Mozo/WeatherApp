package com.juanimozo.weatherapp.ui.components.navigation_drawer

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    onNavigationClick: () -> Unit,
    title: String,
    icon: ImageVector
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Toggle Drawer"
                )
            }
        },
        elevation = 2.dp
    )
}