package com.example.androiddevchallenge.ui.view


import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
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
