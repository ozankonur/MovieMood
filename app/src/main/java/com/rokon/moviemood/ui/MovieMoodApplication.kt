package com.rokon.moviemood.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieMoodApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}