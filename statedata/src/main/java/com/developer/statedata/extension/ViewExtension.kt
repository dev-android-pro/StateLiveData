package com.developer.statedata.extension

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.LinearInterpolator


fun View.fadOutAnimation(
    duration: Long = 100,
    visibility: Int = View.INVISIBLE,
    completion: (() -> Unit)? = null,
) {
    animate()
        .alpha(0f)
        .setDuration(duration)
        .withEndAction {
            this.visibility = visibility
            completion?.let {
                it()
            }
        }

    val v = ValueAnimator.ofFloat(0f, -50f)
    v.addUpdateListener {
        this.translationY = it.animatedValue as Float
    }

    v.interpolator = LinearInterpolator()
    v.duration = duration

    v.start()
}

fun View.fadInAnimation(duration: Long = 100, completion: (() -> Unit)? = null) {
    alpha = 0f
    visibility = View.VISIBLE
    animate()
        .alpha(1f)
        .setDuration(duration)
        .withEndAction {
            completion?.let {
                it()
            }
        }

    val v = ValueAnimator.ofFloat(50f, 0f)
    v.addUpdateListener {
        this.translationY = it.animatedValue as Float
    }
    v.interpolator = LinearInterpolator()
    v.duration = duration

    v.start()
}