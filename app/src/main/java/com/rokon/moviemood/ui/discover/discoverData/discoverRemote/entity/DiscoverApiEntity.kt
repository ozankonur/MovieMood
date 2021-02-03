package com.rokon.moviemood.ui.discover.discoverData.discoverRemote.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class DiscoverApiEntity(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("adult")
    @Expose
    var adult: Boolean,

    @SerializedName("backdrop_path")
    @Expose
    var backdrop_path: String,

    @SerializedName("genre_ids")
    @Expose
    var genre_ids: List<Int>,

    @SerializedName("original_language")
    @Expose
    var original_language: String,

    @SerializedName("original_title")
    @Expose
    var original_title: String,

    @SerializedName("overview")
    @Expose
    var overview: String,

    @SerializedName("popularity")
    @Expose
    var popularity: Double,

    @SerializedName("poster_path")
    @Expose
    var poster_path: String,

    @SerializedName("release_date")
    @Expose
    var release_date: String,

    @SerializedName("title")
    @Expose
    var title: String,
)