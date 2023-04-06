package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.category.MainCategory
import ir.truelearn.androidmvvmsample.data.model.home.*
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    val amazingItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val bestSellerItems = MutableStateFlow<NetworkResult<List<BestItem>>>(NetworkResult.Loading())
    val mostVisitedItems = MutableStateFlow<NetworkResult<List<BestItem>>>(NetworkResult.Loading())
    val superMarketItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val banners = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val mostDiscountedItems = MutableStateFlow<NetworkResult<List<MostDiscountedItem>>>(NetworkResult.Loading())
    val categories = MutableStateFlow<NetworkResult<List<MainCategory>>>(NetworkResult.Loading())
    val centerBannerItems = MutableStateFlow<NetworkResult<List<CenterBannerItem>>>(NetworkResult.Loading())
    val favoriteProducts =MutableStateFlow<NetworkResult<List<FavoriteProduct>>>(NetworkResult.Loading())
    val searching = MutableStateFlow<NetworkResult<List<SearchProductsModel>>>(NetworkResult.Loading())
    val searchProductByBrand = MutableStateFlow<NetworkResult<List<SearchProductsModel>>>(NetworkResult.Loading())


    suspend fun getAllDataFromServer() {
        viewModelScope.launch() {

            launch {
                amazingItems.emit(repository.getAmazingItems())
            }
            launch {
                bestSellerItems.emit(repository.getBestSellerItems())
            }
            launch {
                mostVisitedItems.emit(repository.getMostVisitedItems())
            }
            launch {
                slider.emit(repository.getSlider())
            }
            launch {
                banners.emit(repository.getProposalBanners())
            }
            launch {
                superMarketItems.emit(repository.getSuperMarketItems())
            }
            launch {
                mostDiscountedItems.emit(repository.getMostDiscountedItems())
            }
            launch {
                categories.emit(repository.getCategories())
            }
            launch {
                centerBannerItems.emit(repository.getCenterBannerItems())
            }
            launch {
                favoriteProducts.emit(repository.getMostFavoriteProducts())
            }



        }
    }


    suspend fun searchProduct(q:String) {
        viewModelScope.launch {
            searching.emit(repository.searchProduct(q))
        }
    }

}