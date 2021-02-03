package com.rokon.moviemood.ui.discover.discoverData.discoverRemote.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DiscoverApiResponseEntity(
        @SerializedName("page")
    @Expose
    var page: Int,

        @SerializedName("results")
    @Expose
    var results: List<DiscoverApiEntity>,

        @SerializedName("total_pages")
    @Expose
    var total_pages: Int,

        @SerializedName("total_results")
    @Expose
    var total_results: Int,
)