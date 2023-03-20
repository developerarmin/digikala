package ir.truelearn.androidmvvmsample.data.model.home

data class SearchProductsModel(
    val _id : String,
    val name:String,
    val seller: String,
    val price: String,
    val discountPercent: Int,
    val image : String
)
