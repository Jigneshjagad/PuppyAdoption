/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.puppyList
import com.example.androiddevchallenge.ui.view.PuppyListItem
import com.example.androiddevchallenge.ui.view.PuppyListItemHeader
import com.example.androiddevchallenge.ui.view.Toolbar

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    openDetails: (Int) -> Unit
) {
    Column(Modifier.background(color = Color.DarkGray)) {
        Toolbar()
        val list = puppyList.sortedBy { it.name }.groupBy { it.name }
        LazyColumn(contentPadding = PaddingValues(horizontal = 0.dp, vertical = 4.dp)) {
            list.forEach { (alphabet, puppyDetail) ->
                stickyHeader {
                    PuppyListItemHeader(alphabet.toString())
                }
                itemsIndexed(puppyDetail) { position, puppy ->
                    PuppyListItem(onClick = openDetails, puppyId = puppy.id)
                }
            }
        }
    }
}