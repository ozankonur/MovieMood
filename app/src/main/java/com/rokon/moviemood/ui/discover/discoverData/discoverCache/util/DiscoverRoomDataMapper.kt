package com.rokon.moviemood.ui.discover.discoverData.discoverCache.util

import com.rokon.moviemood.ui.discover.discoverData.discoverCache.entity.DiscoverRoomEntity
import com.rokon.moviemood.ui.discover.discoverData.discoverModel.DiscoverMovieItem
import com.rokon.moviemood.util.mapper.EntityMapper
import javax.inject.Inject

class DiscoverRoomDataMapper
@Inject constructor() : EntityMapper<DiscoverRoomEntity, DiscoverMovieItem> {
    override fun discoverMovieItemFromDiscoverEntity(entity: DiscoverRoomEntity): DiscoverMovieItem {
        return DiscoverMovieItem(
            id = entity.uid,
            adult = entity.adult,
            backdrop_path = entity.backdrop_path,
            genre_ids = entity.genre_ids.map { it.toInt() },
            original_language = entity.original_language,
            original_title = entity.original_title,
            overview = entity.overview,
            popularity = entity.popularity,
            poster_path = entity.poster_path,
            release_date = entity.release_date,
            title = entity.title,
        )
    }

    override fun discoverMovieItemToDiscoverEntity(model: DiscoverMovieItem): DiscoverRoomEntity {
        return DiscoverRoomEntity(
            uid = model.id,
            adult = model.adult,
            backdrop_path = model.backdrop_path,
            genre_ids = model.genre_ids.joinToString(separator = ","),
            original_language = model.original_language,
            original_title = model.original_title,
            overview = model.overview,
            popularity = model.popularity,
            poster_path = model.poster_path,
            release_date = model.release_date,
            title = model.title,
        )
    }

    fun discoverMovieItemListFromDiscoverMovieRoomEntityList(entities: List<DiscoverRoomEntity>): List<DiscoverMovieItem>{
        return entities.map { discoverMovieItemFromDiscoverEntity(it) }
    }
}