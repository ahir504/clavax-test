package com.example.clavaxtest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Zipcode(
    @SerializedName("data")
    val data: Data,
    @SerializedName("error")
    val error: Int,
    @SerializedName("msg")
    val msg: String
) : Serializable
