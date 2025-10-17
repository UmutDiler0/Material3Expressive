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
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.material3expressive.m3_components.AppbarWithSearchField
import com.example.material3expressive.m3_components.BottomBarView
import com.example.material3expressive.m3_components.BtnGroup
import com.example.material3expressive.m3_components.FABMenu
import com.example.material3expressive.m3_components.FloatingTB
import com.example.material3expressive.m3_components.LinearWavyPI
import com.example.material3expressive.m3_components.M3LoadingIndicator
import com.example.material3expressive.m3_components.ShowAlertDialog
import com.example.material3expressive.m3_components.ShowTopAppBar
import com.example.material3expressive.m3_components.SplitBtn

import com.example.material3expressive.ui.theme.Material3ExpressiveTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material3ExpressiveTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = { FloatingTB() },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding).fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        BtnGroup()
                        M3LoadingIndicator()
                        LinearWavyPI()
                        SplitBtn()

                    }
                }
            }
        }
    }
}



