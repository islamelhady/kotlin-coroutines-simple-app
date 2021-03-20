package com.elhady.kotlin.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    var userId: Int,
    val id: Int,
    val title: String,
    val body: String
): Parcelable