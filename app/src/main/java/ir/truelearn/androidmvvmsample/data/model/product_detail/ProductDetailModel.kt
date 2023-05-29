package ir.truelearn.androidmvvmsample.data.model.product_detail

import ir.truelearn.androidmvvmsample.data.model.comment.CommentResponse

data class ProductDetailModel(
    val _id: String,
    val name: String,
    val seller: String,
    val category: String,
    val categoryId: String,
    val price: Int,
    val description:String,
    val discountPercent: Int,
    val star: Double,
    val starCount: Int,
    val viewCount: Int,
    val commentCount: Int,
    val questionCount: Int,
    val agreeCount: Int,
    val agreePercent: Int,
    val colors: List<ColorProductDetail>,
    val comments: List<CommentResponse>,
    val imageSlider: List<ImageSlider>,

)