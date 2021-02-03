package com.rokon.moviemood.ui.discover.discoverData.discoverRemote.retrofit

import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.entity.DiscoverApiResponseEntity
import retrofit2.http.GET

interface DiscoverRetrofitInterface {
    @GET("discover/movie?api_key=8abb11abf63bf9f48700f3e70d6bb7f9")
    suspend fun getMoviesForDiscover(): DiscoverApiResponseEntity
}