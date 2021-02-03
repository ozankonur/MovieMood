package com.rokon.moviemood.util.mapper

interface EntityMapper<Entity, Model> {
    fun discoverMovieItemFromDiscoverEntity(entity: Entity): Model
    fun discoverMovieItemToDiscoverEntity(model: Model): Entity
}