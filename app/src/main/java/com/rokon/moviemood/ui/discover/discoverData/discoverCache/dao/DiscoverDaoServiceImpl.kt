package com.rokon.moviemood.ui.discover.discoverData.discoverCache.dao

import com.rokon.moviemood.ui.discover.discoverData.discoverCache.entity.DiscoverRoomEntity

class DiscoverDaoServiceImpl
constructor (private val discoverDao: DiscoverDao): DiscoverDaoService {
    override suspend fun insert(discoverRoomEntity: DiscoverRoomEntity): Long {
        return discoverDao.insert(discoverRoomEntity)
    }

    override suspend fun get(): List<DiscoverRoomEntity> {
        return discoverDao.get()
    }
}