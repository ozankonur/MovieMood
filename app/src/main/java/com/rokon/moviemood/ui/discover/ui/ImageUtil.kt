package com.rokon.moviemood.ui.discover.ui

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.AmbientContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.rokon.moviemood.BuildConfig
import com.rokon.moviemood.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

const val DEFAULT_RECIPE_IMAGE = R.drawable.place_holder

@ExperimentalCoroutinesApi
@Composable
fun loadPicture(url: String, @DrawableRes defaultImage: Int): MutableState<Bitmap?> {

    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(AmbientContext.current)
            .asBitmap()
            .load(defaultImage)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) { }
                override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                ) {
                    bitmapState.value = resource
                }
            })

    Glide.with(AmbientContext.current)
            .asBitmap()
            .load(BuildConfig.API_BASE_URL_IMAGE + url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) { }
                override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                ) {
                    bitmapState.value = resource
                }
            })

    return bitmapState
}