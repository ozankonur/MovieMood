package com.rokon.moviemood.di.dataModules

import android.content.Context
import androidx.room.Room
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.DiscoverCacheManagerImpl
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.DiscoverCacheManager
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.dao.DiscoverDao
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.dao.DiscoverDaoService
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.dao.DiscoverDaoServiceImpl
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.entity.DiscoverRoomEntity
import com.rokon.moviemood.ui.discover.discoverData.discoverCache.util.DiscoverRoomDataMapper
import com.rokon.moviemood.ui.discover.discoverData.discoverModel.DiscoverMovieItem
import com.rokon.moviemood.util.mapper.EntityMapper
import com.rokon.moviemood.util.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DiscoverRoomModule {

    @Singleton
    @Provides
    fun provideMovieDb(@ApplicationContext context: Context): AppDatabase {
        return Room
                .databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        AppDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideDiscoverDAO(discoverDatabase: AppDatabase): DiscoverDao {
        return discoverDatabase.discoverDao()
    }

    @Singleton
    @Provides
    fun provideDiscoverDaoService(discoverDao: DiscoverDao): DiscoverDaoService {
        return DiscoverDaoServiceImpl(discoverDao)
    }

    @Singleton
    @Provides
    fun provideDiscoverCacheManager(
            discoverDaoService: DiscoverDaoService,
            discoverRoomDataMapper: DiscoverRoomDataMapper
    ): DiscoverCacheManager {
        return DiscoverCacheManagerImpl(discoverDaoService, discoverRoomDataMapper)
    }

    @Singleton
    @Provides
    fun provideDiscoverRoomMapper(): EntityMapper<DiscoverRoomEntity, DiscoverMovieItem> {
        return DiscoverRoomDataMapper()
    }
}