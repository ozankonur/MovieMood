package com.rokon.moviemood.util.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.dao.DiscoverDao
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.entity.DiscoverRoomEntity

@Database(entities = [DiscoverRoomEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun discoverDao(): DiscoverDao

    companion object{
        const val DATABASE_NAME: String = "movie_db"
    }
}