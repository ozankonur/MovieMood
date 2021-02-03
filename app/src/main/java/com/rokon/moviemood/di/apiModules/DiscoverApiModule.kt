package com.rokon.moviemood.di.apiModules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rokon.moviemood.BuildConfig
import com.rokon.moviemood.ui.discover.discoverData.discoverModel.DiscoverMovieItem
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.DiscoverNetworkManager
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.DiscoverNetworkManagerImpl
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.entity.DiscoverApiEntity
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.retrofit.DiscoverRetrofitInterface
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.retrofit.DiscoverRetrofitService
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.retrofit.DiscoverRetrofitServiceImpl
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.util.DiscoverApiMapper
import com.rokon.moviemood.util.mapper.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiscoverApiModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideDiscoverService(retrofit: Retrofit.Builder): DiscoverRetrofitInterface {
        return retrofit
                .build()
                .create(DiscoverRetrofitInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideDiscoverRetrofitService(discoverRetrofitInterface: DiscoverRetrofitInterface): DiscoverRetrofitService {
        return DiscoverRetrofitServiceImpl(discoverRetrofitInterface)
    }

    @Singleton
    @Provides
    fun provideDiscoverNetworkManager(
            discoverRetrofitService: DiscoverRetrofitService,
            discoverApiMapper: DiscoverApiMapper
    ): DiscoverNetworkManager {
        return DiscoverNetworkManagerImpl(discoverRetrofitService, discoverApiMapper)
    }

    @Singleton
    @Provides
    fun provideDiscoveryApiMapper(): EntityMapper<DiscoverApiEntity, DiscoverMovieItem> {
        return DiscoverApiMapper()
    }

}