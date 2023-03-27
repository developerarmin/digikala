package ir.truelearn.androidmvvmsample.data.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.repository.HomeRepository

class ProductDataSource(
    private val repo: HomeRepository
) : PagingSource<Int, SearchProductsModel>() {
    override fun getRefreshKey(state: PagingState<Int, SearchProductsModel>): Int? {
        //todo check for error handling
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchProductsModel> {
        return try {
            val page = params.key ?: 1
            val productResponse = repo.searchProductByBrand1(
                pageNumber = page.toString(),
                pageSize = "10",
                searchValue = "sdf"
            )
            LoadResult.Page(
                data = productResponse,
                prevKey = if (page == 1) null else page - 1,
                nextKey = page.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}