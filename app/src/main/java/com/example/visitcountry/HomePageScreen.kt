package com.example.visitcountry

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visitcountry.model.Country
import com.example.visitcountry.model.CountryDataSource
import com.example.visitcountry.navigation.Screens

@Composable
fun CountryApps(navController: NavController) {
    CountryList(
        countryList = CountryDataSource().loadCountrys(),
        navController = navController
    )
}

@Composable
fun CountryList(
    countryList: List<Country>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(countryList) { navigate ->
            CountryCard(
                country = navigate,
                navController = navController,
                modifier = modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}

@Composable
fun CountryCard(country: Country, modifier: Modifier = Modifier, navController: NavController) {
    var expanded by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer,
    )

    Card(modifier.padding(8.dp)) {
        Surface(color = color) {
            Column(
                modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )
                    .background(color = color)
            ) {
                Row(
                    modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = country.countryImageRes),
                        contentDescription = null,
                        modifier.size(150.dp, 80.dp),
                    )

                    Column(modifier.padding(8.dp)) {
                        Text(
                            text = stringResource(id = country.capitalNameRes),
                        )

                        Spacer(modifier.height(6.dp))

                        Text(
                            text = stringResource(id = country.countryNameRes),
                            style = MaterialTheme.typography.titleLarge,
                        )
                    }

                    Spacer(modifier.weight(1f))

                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                }
                if (expanded) {
                    Column(
                        modifier.padding(
                            start = 16.dp,
                            top = 16.dp,
                            end = 16.dp,
                            bottom = 8.dp
                        )
                    ) {
                        Text(text = stringResource(id = country.countryStructureRes))
                        TextButton(onClick = { navController.navigate(Screens.datailsScreen.route) }) {
                            Text(text = "Detaylar için tıklayınız")
                        }
                    }
                }
            }
        }
    }
}