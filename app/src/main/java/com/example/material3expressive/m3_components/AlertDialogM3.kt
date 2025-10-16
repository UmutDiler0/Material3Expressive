package com.example.material3expressive.m3_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ShowAlertDialog(modifier: Modifier = Modifier){
    val openDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = { openDialog.value = true }) { Text("Open dialog") }

        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = { Text(text = "Title") },
                text = { Text(text = "Turned on by default") },
                confirmButton = {
                    TextButton(onClick = { openDialog.value = false }) { Text("Confirm") }
                },
                dismissButton = {
                    TextButton(onClick = { openDialog.value = false }) { Text("Dismiss") }
                },
            )

        }
    }
}