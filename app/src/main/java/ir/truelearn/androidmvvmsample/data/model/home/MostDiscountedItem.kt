package ir.truelearn.androidmvvmsample.data.model.home

import com.google.gson.annotations.SerializedName

data class MostDiscountedItem (
    val seller: String ,
    val image: String ,
    val discountPercent: Int ,
    val price: Int ,
    val name: String ,
    @SerializedName("_id")
    val Id: String )