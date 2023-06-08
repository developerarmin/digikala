package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.home.FavoriteProduct
import ir.truelearn.androidmvvmsample.data.model.home.Slider
import ir.truelearn.androidmvvmsample.data.model.product_detail.ProductDetailModel
import ir.truelearn.androidmvvmsample.data.model.product_detail.SimilarProduct
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.ProductDetailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val repository: ProductDetailRepository) : ViewModel() {

    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val similarProducts = MutableStateFlow<NetworkResult<List<SimilarProduct>>>(NetworkResult.Loading())
    val recommendedSimilarProducts = MutableStateFlow<NetworkResult<List<FavoriteProduct>>>(NetworkResult.Loading())
    val productDetail = MutableStateFlow<NetworkResult<ProductDetailModel>>(NetworkResult.Loading())
    suspend fun getAllDataFromServer(productId:String) {
        viewModelScope.launch() {
            launch {
                slider.emit(repository.getSlider())
            }
            launch {
                productDetail.emit(repository.getProductById(productId))
            }

            launch {
                recommendedSimilarProducts.emit(repository.getRecommendedSimilarProducts())
            }
        }
    }

    suspend fun getSimilarProducts(categoryId:String){
        viewModelScope.launch() {
            launch {
                similarProducts.emit(repository.getSimilarProducts(categoryId))
            }
        }
    }
}