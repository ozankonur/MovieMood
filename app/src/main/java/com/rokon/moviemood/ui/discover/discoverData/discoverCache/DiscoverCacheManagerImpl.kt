package com.rokon.moviemood.ui.discover.discoverData.discoverCache

import com.rokon.moviemood.ui.discover.discoverData.discoverCache.dao.DiscoverDaoService
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.util.DiscoverRoomDataMapper
import com.rokon.moviemood.ui.discover.discoverData.discoverModel.DiscoverMovieItem

class DiscoverCacheManagerImpl
constructor(
        private val discoverDaoService: DiscoverDaoService,
        private val discoverRoomDataMapper: DiscoverRoomDataMapper
) : DiscoverCacheManager {
    override suspend fun insert(discoverMovieItem: DiscoverMovieItem): Long {
        return discoverDaoService.insert(discoverRoomDataMapper.discoverMovieItemToDiscoverEntity(discoverMovieItem))
    }

    override suspend fun insertList(discoverMovieItems: List<DiscoverMovieItem>) {
        for (discoverMovieItem in discoverMovieItems) {
            discoverDaoService.insert(discoverRoomDataMapper.discoverMovieItemToDiscoverEntity(discoverMovieItem))
        }
    }

    override suspend fun get(): List<DiscoverMovieItem> {
        return discoverRoomDataMapper.discoverMovieItemListFromDiscoverMovieRoomEntityList(discoverDaoService.get())
    }
}