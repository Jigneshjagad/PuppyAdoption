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
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.puppyList
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalFoundationApi
@Composable
fun PuppyDetailsScreen(
    puppyId: Int,
    navigateBack: () -> Unit
) {
    val puppy: Puppy = puppyList[puppyId]
    Column(Modifier.fillMaxHeight()) {
        ToolbarForDetail(
            puppy = puppy,
            navigateBack = navigateBack
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            painter = painterResource(id = puppy.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Row(modifier = Modifier.padding(top = 8.dp)) {
            Card(
                Modifier
                    .weight(1f, true)
                    .padding(start = 8.dp, end = 4.dp)
            ) {
                Column(
                    Modifier
                        .background(color = Color.White)
                ) {
                    Text(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                        text = "Breed"
                    )
                    Text(
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 4.dp,
                            bottom = 8.dp
                        ),
                        text = puppy.breed,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Card(
                Modifier
                    .weight(1f, true)
                    .padding(start = 4.dp, end = 4.dp)
            ) {
                Column(
                    Modifier
                        .background(color = Color.Black.copy(alpha = 0.12f))
                ) {
                    Text(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                        text = "Gender"
                    )
                    Text(
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 4.dp,
                            bottom = 8.dp
                        ),
                        text = puppy.gender.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Card(
                Modifier
                    .weight(1f, true)
                    .padding(start = 4.dp, end = 8.dp)
            ) {
                Column(
                    Modifier
                        .background(color = Color.Black.copy(alpha = 0.12f))
                ) {
                    Text(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                        text = "Age"
                    )
                    Text(
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 4.dp,
                            bottom = 8.dp
                        ),
                        text = "${puppy.age} months",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        Row {
            Card(
                Modifier
                    .weight(1f, true)
                    .padding(start = 8.dp, end = 4.dp, top = 8.dp)
            ) {
                Column(
                    Modifier
                        .background(color = Color.Black.copy(alpha = 0.12f))
                ) {
                    Text(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                        text = "Location"
                    )
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp,
                                top = 4.dp,
                                bottom = 8.dp
                            ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        text = puppy.location
                    )
                }
            }

            Card(
                Modifier
                    .weight(1f, true)
                    .padding(start = 4.dp, end = 8.dp, top = 8.dp)
            ) {
                Column(
                    Modifier
                        .background(color = Color.Black.copy(alpha = 0.12f))
                ) {
                    Text(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                        text = "Weight"
                    )
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp,
                                top = 4.dp,
                                bottom = 8.dp
                            ),
                        overflow = TextOverflow.Ellipsis,
                        text = "${puppy.weight} kg"
                    )
                }
            }
        }

        Card(
            Modifier
                .fillMaxWidth()
                .weight(1f, true)
                .padding(8.dp)
        ) {
            Column(
                Modifier
                    .background(color = Color.Black.copy(alpha = 0.12f))
            ) {
                Text(
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                    text = "Description"
                )
                Text(
                    modifier = Modifier
                        .weight(1f, true)
                        .padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 4.dp,
                            bottom = 8.dp
                        ),
                    overflow = TextOverflow.Ellipsis,
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
                )
            }
        }

        Row {
            Button(
                modifier = Modifier
                    .weight(1f, true)
                    .padding(start = 8.dp, end = 4.dp, bottom = 8.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Adopt")
            }
            Button(
                modifier = Modifier
                    .weight(1f, true)
                    .padding(start = 4.dp, end = 8.dp, bottom = 8.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Contact Us")
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun ToolbarForDetail(
    puppy: Puppy,
    navigateBack: () -> Unit
) {
    MyTheme {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = navigateBack) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            title = { Text(text = puppy.name) },
            actions = {
                IconButton(onClick = {  }) {
                    Icon(
                        Icons.Filled.FavoriteBorder,
                        contentDescription = "Add to favorites",
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            }
        )
    }
}