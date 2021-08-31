package com.bosha.data.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PizzaApiResponse(
	@field:SerializedName("Order_ID")
	val orderID: Int,
	@field:SerializedName("Crust")
	val description: String,
	@field:SerializedName("Size")
	val price: String,
	@field:SerializedName("Table_No")
	val imageResId: Int,
	@field:SerializedName("Flavor")
	val title: String
) : Parcelable

