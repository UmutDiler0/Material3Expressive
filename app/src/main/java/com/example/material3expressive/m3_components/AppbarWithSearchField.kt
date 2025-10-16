package com.example.material3expressive.m3_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AppBarWithSearch
import androidx.compose.material3.ExpandedDockedSearchBar
import androidx.compose.material3.ExpandedFullScreenSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarValue
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppbarWithSearchField(){
    val textFieldState = rememberTextFieldState()
    val searchBarState = rememberSearchBarState()
    val scope = rememberCoroutineScope()
    val scrollBehavior = SearchBarDefaults.enterAlwaysSearchBarScrollBehavior()
    val appBarWithSearchColors = SearchBarDefaults.appBarWithSearchColors()

    val inputField =
        @Composable {
            SearchBarDefaults.InputField(
                modifier = Modifier,
                searchBarState = searchBarState,
                textFieldState = textFieldState,
                onSearch = { scope.launch { searchBarState.animateToCollapsed() } },
                placeholder = {
                    if (searchBarState.currentValue == SearchBarValue.Collapsed) {
                        Text(
                            modifier = Modifier.fillMaxWidth().clearAndSetSemantics {},
                            text = "Search",
                            textAlign = TextAlign.Center,
                        )
                    }
                },
                leadingIcon = {
                    if (searchBarState.currentValue == SearchBarValue.Expanded) {
                        TooltipBox(
                            positionProvider =
                                TooltipDefaults.rememberTooltipPositionProvider(
                                    TooltipAnchorPosition.Above
                                ),
                            tooltip = { PlainTooltip { Text("Back") } },
                            state = rememberTooltipState(),
                        ) {
                            IconButton(
                                onClick = { scope.launch { searchBarState.animateToCollapsed() } }
                            ) {
                                Icon(
                                    Icons.AutoMirrored.Default.ArrowBack,
                                    contentDescription = "Back",
                                )
                            }
                        }
                    } else {
                        Icon(Icons.Default.Search, contentDescription = null)
                    }
                },
                trailingIcon = {
                    TooltipBox(
                        positionProvider =
                            TooltipDefaults.rememberTooltipPositionProvider(
                                TooltipAnchorPosition.Above
                            ),
                        tooltip = { PlainTooltip { Text("Mic") } },
                        state = rememberTooltipState(),
                    ) {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(imageVector = Icons.Default.Mic, contentDescription = "Mic")
                        }
                    }
                },
            )
        }

    AppBarWithSearch(
        scrollBehavior = scrollBehavior,
        state = searchBarState,
        inputField = inputField,
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
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            }
        },
        actions = {
            TooltipBox(
                positionProvider =
                    TooltipDefaults.rememberTooltipPositionProvider(
                        TooltipAnchorPosition.Above
                    ),
                tooltip = { PlainTooltip { Text("Account") } },
                state = rememberTooltipState(),
            ) {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Account",
                    )
                }
            }
        },
        colors = appBarWithSearchColors,
    )
    ExpandedFullScreenSearchBar(state = searchBarState, inputField = inputField) {

    }
}