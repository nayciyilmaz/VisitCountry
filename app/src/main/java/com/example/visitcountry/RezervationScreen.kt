package com.example.visitcountry

import android.annotation.SuppressLint
import android.util.Patterns
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.visitcountry.navigation.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RezervationApp(navController: NavController) {
    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.rezervation_name),
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 30.sp
                    )
                }
            )
        }
    ) {
        RezervationTextField(navController = navController)
    }
}

@Composable
fun RezervationTextField(modifier: Modifier = Modifier, navController: NavController) {
    var inputMail by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var isErrorInPassword by remember { mutableStateOf(false) }
    var isErrorInEmail by remember { mutableStateOf(false) }

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditTextField(
            value = inputMail,
            onValueChange = {
                inputMail = it
                isErrorInEmail = Patterns.EMAIL_ADDRESS.matcher(inputMail).matches().not()
            },
            label = R.string.e_mail,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            supportingText = if (isErrorInEmail) {
                R.string.mail_error
            } else {
                null
            }
        )

        Spacer(modifier.height(30.dp))

        EditTextField(
            value = inputPassword,
            onValueChange = {
                inputPassword = it
                isErrorInPassword = inputPassword.length < 6
            },
            label = R.string.password,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            supportingText = if (isErrorInPassword) {
                R.string.password_error
            } else {
                null
            }
        )

        Spacer(modifier.height(30.dp))

        Button(
            onClick = { navController.navigate(Screens.outScreen.route) },
            shape = RectangleShape,
            enabled = !isErrorInEmail && !isErrorInPassword && inputMail.isNotBlank() && inputPassword.isNotBlank(),
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color(0x0F807F7F),
                contentColor = Color(0xFFDADFDE),
            )
        ) {
            Text(text = "Contunie")
        }
    }
}

@Composable
fun EditTextField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    @StringRes supportingText: Int? = null,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = label)) },
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        supportingText = supportingText?.let {
            {
                Text(
                    text = stringResource(id = it),
                    color = Color(0xFFF50606)
                )
            }
        },
        singleLine = true,
        modifier = modifier
    )
}