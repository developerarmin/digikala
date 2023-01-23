package ir.truelearn.androidmvvmsample.data.model.home

data class MostVisitedItem(
    val _id: String,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Int,
    val seller: String
)