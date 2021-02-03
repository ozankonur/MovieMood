package com.rokon.moviemood.ui.discover.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.rokon.moviemood.ui.discover.DiscoverViewModel
import com.rokon.moviemood.ui.discover.MainStateEvent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun DiscoverFeed(
    modifier: Modifier = Modifier
) {
    val discoverViewModel: DiscoverViewModel = viewModel()
    discoverViewModel.setStateEvent(MainStateEvent.GetDiscoveryEvent)
    val movies by discoverViewModel.dataState.observeAsState(emptyList())

    Surface(Modifier.fillMaxSize()) {
        LazyColumn(
            modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = movies) { feedItem ->
                Text(
                    text = feedItem.title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(8.dp)
                )
                loadPicture(
                    url = feedItem.poster_path,
                    defaultImage = DEFAULT_RECIPE_IMAGE
                ).value?.asImageBitmap()?.let {
                    Image(
                        bitmap = it,
                        feedItem.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .preferredHeight(600.dp),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
    }
}
