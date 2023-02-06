package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.home.FavoriteProduct
import ir.truelearn.androidmvvmsample.data.model.home.Slider
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.HomeRepository
import ir.truelearn.androidmvvmsample.repository.ProductDetailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val repository: ProductDetailRepository) : ViewModel() {
    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    suspend fun getAllDataFromServer() {
        viewModelScope.launch() {
            launch {
                slider.emit(repository.getSlider())
            }
        }
    }
}