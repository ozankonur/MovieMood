package com.rokon.moviemood.ui.discover.discoverData.discoverRemote.util

import com.rokon.moviemood.ui.discover.discoverData.discoverModel.DiscoverMovieItem
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.entity.DiscoverApiEntity
import com.rokon.moviemood.util.mapper.EntityMapper
import javax.inject.Inject

class DiscoverApiMapper
@Inject constructor() : EntityMapper<DiscoverApiEntity,DiscoverMovieItem> {
    override fun discoverMovieItemFromDiscoverEntity(entity: DiscoverApiEntity): DiscoverMovieItem {
        return DiscoverMovieItem(
            id = entity.id,
            adult = entity.adult,
            backdrop_path = entity.backdrop_path,
            genre_ids = entity.genre_ids,
            original_language = entity.original_language,
            original_title = entity.original_title,
            overview = entity.overview,
            popularity = entity.popularity,
            poster_path = entity.poster_path,
            release_date = entity.release_date,
            title = entity.title,
        )
    }

    override fun discoverMovieItemToDiscoverEntity(model: DiscoverMovieItem): DiscoverApiEntity {
        return DiscoverApiEntity(
            id = model.id,
            adult = model.adult,
            backdrop_path = model.backdrop_path,
            genre_ids = model.genre_ids,
            original_language = model.original_language,
            original_title = model.original_title,
            overview = model.overview,
            popularity = model.popularity,
            poster_path = model.poster_path,
            release_date = model.release_date,
            title = model.title,
        )
    }

    fun discoverMovieItemListFromApiEntityList(entities: List<DiscoverApiEntity>): List<DiscoverMovieItem>{
        return entities.map { discoverMovieItemFromDiscoverEntity(it) }
    }

}