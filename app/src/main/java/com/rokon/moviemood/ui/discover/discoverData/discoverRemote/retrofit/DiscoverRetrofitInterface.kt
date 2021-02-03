package com.rokon.moviemood.ui.discover.discoverData.discoverRemote.retrofit

import com.rokon.moviemood.BuildConfig
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.entity.DiscoverApiResponseEntity
import retrofit2.http.GET

interface DiscoverRetrofitInterface {
    @GET("discover/movie?api_key=" + BuildConfig.API_KEY)
    suspend fun getMoviesForDiscover(): DiscoverApiResponseEntity
}