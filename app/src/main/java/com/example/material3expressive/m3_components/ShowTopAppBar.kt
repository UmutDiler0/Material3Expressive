package com.example.material3expressive.m3_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Attachment
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Snooze
import androidx.compose.material.icons.outlined.MarkEmailUnread
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.AppBarRow
import androidx.compose.material3.ExpandedFullScreenSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarValue
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.style.TextAlign
import androidx.window.core.layout.WindowWidthSizeClass

import com.google.android.gms.fido.Fido
import com.google.android.gms.fido.fido2.Fido2ApiClient
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowTopAppBar(){
    val sizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val maxItemCount = when (sizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 3
        WindowWidthSizeClass.MEDIUM -> 5
        WindowWidthSizeClass.EXPANDED -> 7
        else -> 3
    }
    val icons =
        listOf(
            Icons.Filled.Attachment,
            Icons.Filled.Edit,
            Icons.Outlined.Star,
            Icons.Filled.Snooze,
            Icons.Outlined.MarkEmailUnread,
        )
    val items = listOf("Attachment", "Edit", "Star", "Snooze", "Mark unread")

    TopAppBar(
        title = {
            Text("Simple TopAppBar", maxLines = 1, overflow = TextOverflow.Ellipsis)
        },
        navigationIcon = {
            TooltipBox(
                positionProvider =
                    TooltipDefaults.rememberTooltipPositionProvider(
                        TooltipAnchorPosition.Above
                    ),
                tooltip = { PlainTooltip { Text("Menu") } },
                state = rememberTooltipState(),
            ) {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        },
        actions = {
            AppBarRow(
                maxItemCount = maxItemCount,
                overflowIndicator = {
                    TooltipBox(
                        positionProvider =
                            TooltipDefaults.rememberTooltipPositionProvider(
                                TooltipAnchorPosition.Above
                            ),
                        tooltip = { PlainTooltip { Text("Overflow") } },
                        state = rememberTooltipState(),
                    ) {
                        IconButton(onClick = { it.show() }) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "Overflow",
                            )
                        }
                    }
                },
            ) {
                items.forEachIndexed { index, item ->
                    clickableItem(
                        onClick = {},
                        icon = {
                            Icon(imageVector = icons[index], contentDescription = item)
                        },
                        label = item,
                    )
                }
            }
        },
    )
}

