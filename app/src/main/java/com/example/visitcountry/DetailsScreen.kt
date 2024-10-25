package com.example.visitcountry

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.visitcountry.navigation.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreenApp(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.details_name),
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 30.sp
                    )
                }
            )
        }
    ) {
        DetailsScreen(navController = navController)
    }
}

@Composable
fun DetailsScreen(modifier: Modifier = Modifier, navController: NavController) {
    var imageResult by remember { mutableIntStateOf(1) }
    var nameResult by remember { mutableIntStateOf(1) }
    var expanded by remember { mutableStateOf(false) }

    val imageResource = when (imageResult) {
        1 -> R.drawable.brandenburgkapisi
        2 -> R.drawable.kolnkatedrali
        else -> R.drawable.reichstagbinasi
    }

    val nameResource = when (nameResult) {
        1 -> R.string.brandenburg
        2 -> R.string.koln
        else -> R.string.reichstag
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier
                .size(400.dp, 300.dp)
                .padding(start = 12.dp, end = 12.dp)
                .clickable { expanded = !expanded },
            contentScale = ContentScale.Crop,
        )

        if (expanded) {
            Card(
                modifier
                    .padding(3.dp)
                    .size(300.dp, 50.dp)
            ) {
                Text(
                    text = stringResource(id = nameResource),
                    modifier.padding(horizontal = 72.dp, vertical = 12.dp)
                )
            }
        }
        Row(modifier.padding(15.dp)) {
            Button(
                onClick = {
                    if (imageResult != 1 && nameResult != 1) {
                        imageResult--
                        nameResult--
                    }
                }, modifier.weight(1f)
            ) {
                Text(
                    text = "Previous Photo"
                )
            }

            Spacer(modifier.width(5.dp))

            Button(
                onClick = {
                    if (imageResult != 3 && nameResult != 3) {
                        imageResult++
                        nameResult++
                    }
                }, modifier.weight(1f)
            ) {
                Text(text = "Next Photo")
            }
        }
        Button(
            onClick = {
                navController.navigate(Screens.rezervationScreen.route)
            }, modifier.padding(10.dp)
        ) {
            Text(
                text = "Rezervasyon"
            )
        }
    }
}


