package com.example.fakestore.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("geolocation")
    val geolocation: Geolocation,
    @SerializedName("number")
    val number: Int,
    @SerializedName("street")
    val street: String,
    @SerializedName("zipcode")
    val zipcode: String
) : Parcelable