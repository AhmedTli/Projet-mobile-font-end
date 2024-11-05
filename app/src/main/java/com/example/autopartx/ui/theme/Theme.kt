package com.example.autopartx.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Red, // Set your primary color
    onPrimary = White, // Set the color for content on primary
    secondary = Red, // You can customize secondary as well
    onSecondary = Black,
    background = Black, // Background color
    onBackground = White, // Content on background
    surface = Black, // Surface color
    onSurface = White // Content on surface
)

private val LightColorScheme = lightColorScheme(
    primary = Red,          // Use Red as the primary color
    onPrimary = White,      // White text/icons on primary
    secondary = Black,      // Use Black as the secondary color
    onSecondary = White,    // White text/icons on secondary
    background = White,     // Set background to white
    onBackground = Black,    // Black text/icons on white background
    surface = White,        // Surface color is white
    onSurface = Black       // Black text/icons on surface

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AutoPartXTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}