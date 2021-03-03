package com.example.androiddevchallenge.ui.view


import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

@Preview
@Composable
fun Toolbar() {
    MyTheme {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { }, enabled = false) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home_24),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            title = { Text(text = stringResource(id = R.string.app_name)) }
        )
    }
}

@Preview
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
                IconButton(onClick = { /*TODO*/ }) {
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
