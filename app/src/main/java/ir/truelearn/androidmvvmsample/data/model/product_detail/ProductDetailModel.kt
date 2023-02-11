package ir.truelearn.androidmvvmsample.data.model.product_detail

data class ProductDetailModel(
    val _id: String,
    val agreeCount: Int,
    val agreePercent: Int,
    val colors: List<ColorProductDetail>,
    val commentCount: Int,
    val comments: List<Comment>,
    val discountPercent: Int,
    val imageSlider: List<ImageSlider>,
    val name: String,
    val price: Int,
    val questionCount: Int,
    val seller: String,
    val star: Double,
    val starCount: Int
)