package com.rokon.moviemood.ui.discover.discoverData.discoverModel

data class DiscoverMovieItem(
    var adult: Boolean,
    var backdrop_path: String,
    var genre_ids: List<Int>,
    var id: Int,
    var original_language: String,
    var original_title: String,
    var overview: String,
    var popularity: Double,
    var poster_path: String,
    var release_date: String,
    var title: String,
)