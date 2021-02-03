package com.rokon.moviemood.di.repositoryModules

import com.rokon.moviemood.ui.discover.DiscoverRepository
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.DiscoverCacheManager
import com.rokon.moviemood.ui.discover.discoverData.discoverRemote.DiscoverNetworkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDiscoverRepository(
            discoverCacheManager: DiscoverCacheManager,
            discoverNetworkManager: DiscoverNetworkManager
    ): DiscoverRepository {
        return DiscoverRepository(discoverCacheManager,discoverNetworkManager)
    }
}