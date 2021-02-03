package com.rokon.moviemood.ui.discover.discoverData.discoverCache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.entity.DiscoverRoomEntity

@Dao
interface DiscoverDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(discoverRoomEntity: DiscoverRoomEntity): Long

    @Query("SELECT * FROM discover_movies")
    suspend fun get(): List<DiscoverRoomEntity>
}