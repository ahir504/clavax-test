package com.example.clavaxtest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Data(
    @SerializedName("count")
    val count: Int,
    @SerializedName("list")
    val list: List<ZipList>
) : Serializable
