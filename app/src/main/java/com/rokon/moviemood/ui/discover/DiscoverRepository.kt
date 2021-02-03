package com.rokon.moviemood.ui.discover

import com.rokon.moviemood.ui.discover.discoverData.discoverCache.DiscoverCacheManager
import com.rokon.moviemood.ui.discover.discoverData.discoverModel.DiscoverMovieItem
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.DiscoverNetworkManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DiscoverRepository constructor(
        private val discoverCacheManager: DiscoverCacheManager,
        private val discoverNetworkManager: DiscoverNetworkManager
) {
    suspend fun getDiscoverMovies(): Flow<List<DiscoverMovieItem>> = flow {
            val discoverMovies = discoverNetworkManager.getMoviesForDiscover()
            discoverCacheManager.insertList(discoverMovies)
            emit(discoverCacheManager.get())
    }
}