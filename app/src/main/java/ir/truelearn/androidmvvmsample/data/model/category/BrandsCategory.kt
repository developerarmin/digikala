package ir.truelearn.androidmvvmsample.data.model.category

data class BrandsCategory(
    val beauty: List<BrandsSub>,
    val book: List<BrandsSub>,
    val digital: List<BrandsSub>,
    val fashion: List<BrandsSub>,
    val home: List<BrandsSub>,
    val mobile: List<BrandsSub>,
    val native: List<BrandsSub>,
    val sport: List<BrandsSub>,
    val supermarket: List<BrandsSub>,
    val tool: List<BrandsSub>,
    val toy: List<BrandsSub>
)

data class BrandsSub(
    val _id: String,
    val image: String,
    val name: String
)
