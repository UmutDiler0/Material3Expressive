package com.example.material3expressive.m3_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Work
import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BtnGroup(modifier: Modifier = Modifier){
    val numButtons = 10
    ButtonGroup(
        overflowIndicator = { menuState ->
            ButtonGroupDefaults.OverflowIndicator(menuState = menuState)
        }
    ) {
        for (i in 0 until numButtons) {
            clickableItem(onClick = {}, label = "$i")
        }
    }
    val options = listOf("Work", "Restaurant", "Coffee")
    val unCheckedIcons =
        listOf(Icons.Outlined.Work, Icons.Outlined.Restaurant, Icons.Outlined.Coffee)
    val checkedIcons = listOf(Icons.Filled.Work, Icons.Filled.Restaurant, Icons.Filled.Coffee)
    var selectedIndex by remember { mutableIntStateOf(0) }

    Row(
        Modifier.padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(ButtonGroupDefaults.ConnectedSpaceBetween),
    ) {
        val modifiers = listOf(Modifier.weight(1f), Modifier.weight(1.5f), Modifier.weight(1f))

        options.forEachIndexed { index, label ->
            ToggleButton(
                checked = selectedIndex == index,
                onCheckedChange = { selectedIndex = index },
                modifier = modifiers[index].semantics { role = Role.RadioButton },
                shapes =
                    when (index) {
                        0 -> ButtonGroupDefaults.connectedLeadingButtonShapes()
                        options.lastIndex -> ButtonGroupDefaults.connectedTrailingButtonShapes()
                        else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
                    },
            ) {
                Icon(
                    if (selectedIndex == index) checkedIcons[index] else unCheckedIcons[index],
                    contentDescription = "Localized description",
                )
                Spacer(Modifier.size(ToggleButtonDefaults.IconSpacing))
                Text(label)
            }
        }
    }
}