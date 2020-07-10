package org.example.app.ext

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
Created by Denis Chornyy on 10,Июль,2020
All rights received.
 */

@BindingAdapter("image")
fun setImage(image: ImageView, url: String?) {
    Glide.with(image.context).load(url).centerCrop()
            .into(image)
}