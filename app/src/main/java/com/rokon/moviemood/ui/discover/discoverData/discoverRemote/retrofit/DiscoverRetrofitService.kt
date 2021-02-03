package com.rokon.moviemood.ui.discover.discoverData.discoverRemote.retrofit

import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.entity.DiscoverApiResponseEntity

interface DiscoverRetrofitService {
    suspend fun getMoviesForDiscover(): DiscoverApiResponseEntity
}