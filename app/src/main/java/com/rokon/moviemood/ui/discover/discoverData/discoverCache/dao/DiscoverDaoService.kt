package com.rokon.moviemood.ui.discover.discoverData.discoverCache.dao

import com.rokon.moviemood.ui.discover.discoverData.discoverCache.entity.DiscoverRoomEntity

interface DiscoverDaoService {
    suspend fun insert(discoverRoomEntity: DiscoverRoomEntity): Long
    suspend fun get(): List<DiscoverRoomEntity>
}