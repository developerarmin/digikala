package ir.truelearn.androidmvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.data.model.AmazingItem
import ir.truelearn.androidmvvmsample.data.model.Banners
import ir.truelearn.androidmvvmsample.data.model.Slider
import ir.truelearn.androidmvvmsample.data.model.SuperMarketItem
import ir.truelearn.androidmvvmsample.data.remote.NetworkResult
import ir.truelearn.androidmvvmsample.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    val amazingItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val superMarketItems = MutableStateFlow<NetworkResult<List<SuperMarketItem>>>(NetworkResult.Loading())
    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val banners = MutableStateFlow<NetworkResult<List<Banners>>>(NetworkResult.Loading())

    suspend fun getAllDataFromServer() {
        viewModelScope.launch(Dispatchers.Main) {
            val amazingResult = async { repository.getAmazingItems() }
            val sliderResult = async { repository.getSlider() }
            val bannerResult = async { repository.getProposalBanners()}
            val superMarketResult = async { repository.getSuperMarketItems() }


            amazingItems.emit(amazingResult.await())
            slider.emit(sliderResult.await())
            banners.emit(bannerResult.await())
            superMarketItems.emit(superMarketResult.await())

        }
    }

}