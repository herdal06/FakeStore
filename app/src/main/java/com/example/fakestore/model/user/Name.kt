package com.example.fakestore.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("lastname")
    val lastname: String
) : Parcelable