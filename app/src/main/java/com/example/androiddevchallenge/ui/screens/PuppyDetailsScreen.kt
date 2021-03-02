package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.puppyList
import com.example.androiddevchallenge.ui.view.ToolbarForDetail

@ExperimentalFoundationApi
@Composable
fun PuppyDetailsScreen(
    puppyId:Int,
    navigateBack:()->Unit
){
    val puppy:Puppy = puppyList[puppyId]
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

        Row (modifier = Modifier.padding(top = 8.dp)){
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