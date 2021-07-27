package com.developer.statedata

import android.animation.ValueAnimator
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.TextView
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject

fun JSONObject.toRequestBody() {
    this.toString().toRequestBody("application/json".toMediaType())
}

fun JSONArray.toRequestBody() {
    this.toString().toRequestBody("application/json".toMediaType())
}
