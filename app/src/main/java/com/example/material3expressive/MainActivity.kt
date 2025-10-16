package com.example.material3expressive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.material3expressive.m3_components.AppbarWithSearchField
import com.example.material3expressive.m3_components.BottomBarView
import com.example.material3expressive.m3_components.ShowAlertDialog
import com.example.material3expressive.m3_components.ShowTopAppBar

import com.example.material3expressive.ui.theme.Material3ExpressiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material3ExpressiveTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { AppbarWithSearchField() },
                    bottomBar = { BottomBarView() }
                ) { innerPadding ->
                    ShowAlertDialog(Modifier.padding(innerPadding))
                }
            }
        }
    }
}



