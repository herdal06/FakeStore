package com.example.fakestore.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Geolocation(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("long")
    val long: String
): Parcelable