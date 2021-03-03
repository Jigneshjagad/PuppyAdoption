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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Gender
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.puppyList
import com.example.androiddevchallenge.ui.theme.MyTheme
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

@ExperimentalFoundationApi
@Composable
fun PuppyListItem(
    puppyId: Int = 0,
    onClick: (Int) -> Unit
) {
    val puppy: Puppy = puppyList[puppyId]
    MyTheme {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clickable(onClick = { onClick(puppyId) })
        ) {
            Column(Modifier.background(color = Color.LightGray)) {
                Row(Modifier.height(120.dp), verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier.width(120.dp),
                        painter = painterResource(id = puppy.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Column(modifier = Modifier.weight(1.0f, true)) {
                        Text(
                            text = puppy.name, color = Color.Black,
                            modifier = Modifier
                                .weight(1.0f)
                                .padding(start = 16.dp, end = 8.dp, top = 16.dp),
                            fontWeight = FontWeight.Medium,
                        )
                        Text(
                            text = puppy.breed,
                            color = Color.DarkGray,
                            modifier = Modifier
                                .weight(1.0f)
                                .padding(start = 16.dp, end = 8.dp, bottom = 8.dp)
                        )
                        val genderIcon =
                            if (puppy.gender == Gender.Male) Icons.Filled.Male else Icons.Filled.Female
                        val genderColor = if (puppy.gender == Gender.Male) Color.Blue else Color.Red
                        Icon(
                            genderIcon,
                            contentDescription = null,
                            tint = genderColor.copy(alpha = 0.4f),
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            }
        }

    }
}