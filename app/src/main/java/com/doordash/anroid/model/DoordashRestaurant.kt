package com.doordash.anroid.model

import com.google.gson.annotations.SerializedName

data class DoordashRestaurant(
    val id: Long?,
    val name: String?,
    @SerializedName("description") val typeOfFood: String?,
    @SerializedName("cover_img_url") val restaurantThumbnailUrl: String?,
    val status: String?,
    @SerializedName("address") val address: Address? = null,
    @SerializedName("delivery_fee") val deliveryFeeInCents: Float?
)


data class Address(
    @SerializedName("printable_address") val printableAddress: String?
)


