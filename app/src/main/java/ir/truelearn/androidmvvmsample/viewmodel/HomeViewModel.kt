package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.category.MainCategory
import ir.truelearn.androidmvvmsample.data.model.home.MostDiscountedItem
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.home.BestItem
import ir.truelearn.androidmvvmsample.data.model.home.Slider
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
    val bestSellerItems =
        MutableStateFlow<NetworkResult<List<BestItem>>>(NetworkResult.Loading())
    val mostVisitedItems =
        MutableStateFlow<NetworkResult<List<BestItem>>>(NetworkResult.Loading())
    val superMarketItems =
        MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val banners = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val mostDiscountedItems = MutableStateFlow<NetworkResult<List<MostDiscountedItem>>>(NetworkResult.Loading())
    val categories = MutableStateFlow<NetworkResult<List<MainCategory>>>(NetworkResult.Loading())

    suspend fun getAllDataFromServer() {
        viewModelScope.launch(Dispatchers.Main) {
            val amazingResult = async { repository.getAmazingItems() }
            val bestSellerResult = async { repository.getBestSellerItems() }
            val mostVisitedResult = async { repository.getMostVisitedItems() }
            val sliderResult = async { repository.getSlider() }
            val bannerResult = async { repository.getProposalBanners() }
            val superMarketResult = async { repository.getSuperMarketItems() }
            val mostDiscountedResult = async { repository.getMostDiscountedItems() }
            val categoryResult = async { repository.getCategories() }


            amazingItems.emit(amazingResult.await())
            bestSellerItems.emit(bestSellerResult.await())
            mostVisitedItems.emit(mostVisitedResult.await())
            slider.emit(sliderResult.await())
            banners.emit(bannerResult.await())
            superMarketItems.emit(superMarketResult.await())
            mostDiscountedItems.emit(mostDiscountedResult.await())
            categories.emit(categoryResult.await())

        }
    }

}