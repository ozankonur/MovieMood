package com.rokon.moviemood.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import com.rokon.moviemood.ui.discover.ui.DiscoverFeed
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val DarkColors = darkColors(
        primary = Color.Black,
        secondary = Color.Gray,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                drawerContent = { },
                topBar = { },
                bodyContent = {
                    MaterialTheme(colors = DarkColors) {
                        DiscoverFeed()
                    }
                }
            )
        }
    }
}