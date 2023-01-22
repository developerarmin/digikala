package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.home.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.home.BestSellerItem
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
        MutableStateFlow<NetworkResult<List<BestSellerItem>>>(NetworkResult.Loading())
    val superMarketItems =
        MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val banners = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())

    suspend fun getAllDataFromServer() {
        viewModelScope.launch(Dispatchers.Main) {
            val amazingResult = async { repository.getAmazingItems() }
            val bestSellerResult = async { repository.getBestSellerItems() }
            val sliderResult = async { repository.getSlider() }
            val bannerResult = async { repository.getProposalBanners() }
            val superMarketResult = async { repository.getSuperMarketItems() }


            amazingItems.emit(amazingResult.await())
            bestSellerItems.emit(bestSellerResult.await())
            slider.emit(sliderResult.await())
            banners.emit(bannerResult.await())
            superMarketItems.emit(superMarketResult.await())

        }
    }

}