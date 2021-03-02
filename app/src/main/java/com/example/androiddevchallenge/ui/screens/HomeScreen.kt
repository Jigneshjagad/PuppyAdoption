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
    Column (Modifier.background(color = Color.DarkGray)) {
        Toolbar()
        val list = puppyList.sortedBy { it.name }.groupBy { it.name }
        LazyColumn(contentPadding = PaddingValues(horizontal = 0.dp, vertical = 4.dp)) {
            list.forEach { (alphabet, puppyDetail) ->
                stickyHeader {
                    PuppyListItemHeader(alphabet.toString())
                }
                itemsIndexed(puppyDetail) { position, puppy ->
                    PuppyListItem(onClick = openDetails,puppyId = puppy.id)
                }
            }
        }
    }
}