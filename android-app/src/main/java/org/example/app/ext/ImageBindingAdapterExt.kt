package org.example.app.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import dev.icerock.moko.resources.ImageResource

object ImageBindingAdapterExt {
    @JvmStatic
    @BindingAdapter("image")
    fun ImageView.setImageResource(src: ImageResource) {
        setImageResource(src.drawableResId)
    }
}