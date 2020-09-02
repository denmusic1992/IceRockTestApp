package org.example.app.ext

import android.widget.TextView
import androidx.databinding.BindingAdapter
import dev.icerock.moko.resources.FontResource

object TextViewBindingAdapterExt {
    @JvmStatic
    @BindingAdapter("setFont")
    fun TextView.setFont(font: FontResource) {
        typeface = font.getTypeface(context)
    }
}