package com.rokon.moviemood.ui.discover.discoverData.discoverRemote

import com.rokon.moviemood.ui.discover.discoverData.discoverModel.DiscoverMovieItem
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.retrofit.DiscoverRetrofitService
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.util.DiscoverApiMapper

class DiscoverNetworkManagerImpl
constructor(
        private val discoverRetrofitService: DiscoverRetrofitService,
        private val discoverApiMapper: DiscoverApiMapper
) : DiscoverNetworkManager {
    override suspend fun getMoviesForDiscover(): List<DiscoverMovieItem> {
        return discoverApiMapper.discoverMovieItemListFromApiEntityList(discoverRetrofitService.getMoviesForDiscover().results)
    }
}