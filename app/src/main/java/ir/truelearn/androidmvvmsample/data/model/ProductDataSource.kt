package ir.truelearn.androidmvvmsample.data.model

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.repository.HomeRepository

class ProductDataSource(
    private val repo: HomeRepository,
    var searchValue : String,
) : PagingSource<Int, SearchProductsModel>() {
    override fun getRefreshKey(state: PagingState<Int, SearchProductsModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchProductsModel> {

        return try {
            val nextPageNumber = params.key ?: 1
            val response = repo.searchProductByBrand(
                pageNumber = nextPageNumber.toString(),
                pageSize = "10",
                searchValue = searchValue
            ).data
            Log.d("2121", "load:${response.size} ")
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = if (response.isNotEmpty()) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            Log.d("2121", "error:$e ")
            LoadResult.Error(e)
        }

    }
}
