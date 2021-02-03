package com.rokon.moviemood.ui.discover.discoverData.discoverCache

import com.rokon.moviemood.ui.discover.discoverData.discoverModel.DiscoverMovieItem

interface DiscoverCacheManager {
    suspend fun insert(discoverMovieItem: DiscoverMovieItem): Long
    suspend fun insertList(discoverMovieItems: List<DiscoverMovieItem>)
    suspend fun get(): List<DiscoverMovieItem>
}