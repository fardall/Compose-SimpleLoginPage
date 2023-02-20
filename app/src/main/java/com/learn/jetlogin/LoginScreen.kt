package com.learn.jetlogin

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.jetlogin.ui.theme.JetLoginTheme

@Composable
fun LoginScreen(
    navigateToHome: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { value -> username = value },
            label = { Text("Username") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { value -> password = value },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = "Visibility"
                    )
                }
            }

        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (username == "admin" && password == "admin") {
                    Toast.makeText(
                        context,
                        "Login Successful",
                        Toast.LENGTH_SHORT
                    ).show()
                    navigateToHome(username)
                } else {
                    Toast.makeText(
                        context,
                        "Invalid username or password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {
            Text("Login")
        }
    }
}

@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun LoginScreenPreview() {
    JetLoginTheme {
        LoginScreen(navigateToHome = { username -> })
    }
}