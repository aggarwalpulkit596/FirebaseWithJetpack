package com.puldroid.firebasejetpack.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observer(owner: LifecycleOwner, onEmission: (T) -> Unit) {
    return observe(owner, Observer<T> {
        if (it != null) {
            onEmission(it)
        }
    })
}