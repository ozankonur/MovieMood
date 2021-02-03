package com.rokon.moviemood.ui.discover.discoverData.discoverRemote

import com.rokon.moviemood.ui.discover.discoverData.discoverModel.DiscoverMovieItem

interface DiscoverNetworkManager {
    suspend fun getMoviesForDiscover(): List<DiscoverMovieItem>
}