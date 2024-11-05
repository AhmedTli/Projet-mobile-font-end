package com.example.autopartx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.autopartx.ui.theme.AutoPartXTheme
import com.example.autopartx.view.AutoPartApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AutoPartXTheme {
                AutoPartApp()
            }
        }
    }
}