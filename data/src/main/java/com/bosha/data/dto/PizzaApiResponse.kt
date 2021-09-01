package com.bosha.data.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@kotlinx.parcelize.Parcelize
data class PizzaApiResponse(
    @field:SerializedName("count")
    val price: Int,
    val description: String,
    @field:SerializedName("frequency")
    val imageResId: Int = 0,
    val title: String,
    val type: Int = 0,
    val date: Long = 0,
    val uid: String,
    val priority: Int = 0,
) : Parcelable

//Fields title, description, priority, type, count, frequency and date