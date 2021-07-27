package com.developer.statedata

import android.widget.TextView
import com.developer.statedata.extension.fadInAnimation
import com.developer.statedata.extension.fadOutAnimation


fun TextView.addText(
    text: String,
    duration: Long = 150,
    completion: (() -> Unit)? = null,
) {
    fadOutAnimation(duration) {
        this.text = text
        fadInAnimation(duration) {
            completion?.let {
                it()
            }
        }
    }
}
