package ir.truelearn.androidmvvmsample.data.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.truelearn.androidmvvmsample.data.model.home.SearchProductsModel
import ir.truelearn.androidmvvmsample.repository.HomeRepository

class ProductDataSource(
    private val repo:HomeRepository
):PagingSource<Int,SearchProductsModel>() {
    override fun getRefreshKey(state: PagingState<Int, SearchProductsModel>): Int? {
        //todo check for error handling
       return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchProductsModel> {
        return try {
            val nextPage = params.key ?: 1
            val userList=repo.searchProductByBrand(pageNumber = nextPage.toString(), pageSize = "2", searchValue = "sdf")
            LoadResult.Page(
                data = userList.data,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (userList.data.isEmpty()) null else userList.page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
    }
}