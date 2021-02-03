package com.rokon.moviemood.ui.discover.discoverData.discoverRemote.retrofit

import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.entity.DiscoverApiResponseEntity

class DiscoverRetrofitServiceImpl
constructor(
        private val discoverRetrofitInterface: DiscoverRetrofitInterface
) : DiscoverRetrofitService {
    override suspend fun getMoviesForDiscover(): DiscoverApiResponseEntity {
        return discoverRetrofitInterface.getMoviesForDiscover()
    }
}