package com.example.visitcountry

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.visitcountry.navigation.Screens

@Composable
fun OutScreenApp(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    var switchState by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(50.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.onay),
            contentDescription = null
        )

        Spacer(modifier.height(30.dp))

        Text(
            text = stringResource(id = R.string.rezervation_details),
            modifier.padding(start = 15.dp,end = 15.dp)
        )

        Spacer(modifier.height(30.dp))

        Switch(
            checked = switchState,
            onCheckedChange = { switchState = !switchState}
        )

        if (switchState) {
            AlertDialog(
                onDismissRequest = {
                },
                title = { Text(text = "Onaylama ve Çıkış") },
                text = { Text(text = "Onayladığınız durumda rezervasyonunuz kesin oluşacaktır") },
                modifier = modifier,
                dismissButton = {
                    TextButton(
                        onClick = {
                            navController.navigate(Screens.homepageScreen.route)
                        }
                    ) {
                        Text(text = "Yes")
                    }
                },
                confirmButton = {
                    TextButton(onClick = {
                        navController.navigate(Screens.outScreen.route)
                    }) {
                        Text(text = "No")
                    }
                }
            )
        }
    }
}