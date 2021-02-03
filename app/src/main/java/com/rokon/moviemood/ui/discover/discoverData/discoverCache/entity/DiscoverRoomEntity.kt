package com.rokon.moviemood.ui.discover.discoverData.discoverCache.entity

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Immutable
@Entity(tableName = "discover_movies")
data class DiscoverRoomEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var uid: Int,

    @ColumnInfo(name = "adult")
    var adult: Boolean,

    @ColumnInfo(name = "backdrop_path")
    var backdrop_path: String,

    @ColumnInfo(name = "genre_ids")
    var genre_ids: String,

    @ColumnInfo(name = "original_language")
    var original_language: String,

    @ColumnInfo(name = "original_title")
    var original_title: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "popularity")
    var popularity: Double,

    @ColumnInfo(name = "poster_path")
    var poster_path: String,

    @ColumnInfo(name = "release_date")
    var release_date: String,

    @ColumnInfo(name = "title")
    var title: String,
)