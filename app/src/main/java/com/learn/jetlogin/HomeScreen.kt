package com.learn.jetlogin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.learn.jetlogin.ui.theme.JetLoginTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    username: String
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello, $username!")
    }
}

@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun HomeScreenPreview() {
    JetLoginTheme {
        HomeScreen(username = "admin")
    }
}