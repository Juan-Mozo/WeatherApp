package com.juanimozo.weatherapp.ui.components.navigation_drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.juanimozo.weatherapp.ui.theme.Values

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    .padding(Values.Padding.medium)
            ) {
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.contentDescription
                )
                Spacer(modifier = Modifier.width(Values.Spacer.medium))
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }

}