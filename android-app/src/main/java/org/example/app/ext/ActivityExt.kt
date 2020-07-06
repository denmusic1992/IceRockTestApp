package org.example.app.ext

import android.app.Activity
import android.widget.Toast

/**
Created by Denis Chornyy on 06,Июль,2020
All rights received.
 */
fun Activity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.errToast(err: String) {
    Toast.makeText(this, "exception: $err", Toast.LENGTH_LONG).show()
}