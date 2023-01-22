package ir.truelearn.androidmvvmsample.data.model.category

data class SubCategory(
    val beauty: List<Sub>,
    val book: List<Sub>,
    val digital: List<Sub>,
    val fashion: List<Sub>,
    val home: List<Sub>,
    val mobile: List<Sub>,
    val native: List<Sub>,
    val sport: List<Sub>,
    val supermarket: List<Sub>,
    val tool: List<Sub>,
    val toy: List<Sub>
)

data class Sub(
    val _id: String,
    val count: Int,
    val image: String,
    val name: String
)

