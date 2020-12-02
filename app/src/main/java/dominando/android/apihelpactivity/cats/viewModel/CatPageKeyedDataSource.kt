package dominando.android.apihelpactivity.cats.viewModel

import androidx.paging.PageKeyedDataSource
import dominando.android.apihelpactivity.cats.Api.ResponseApiCats
import dominando.android.apihelpactivity.cats.CatRepository
import dominando.android.apihelpactivity.cats.model.Result
import dominando.android.apihelpactivity.cats.model.Serie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatPageKeyedDataSource : PageKeyedDataSource<Int, Result>() {
companion object{
    const val FIRST_PAGE = 1
}
    private val repository by lazy {
        CatRepository()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, dominando.android.apihelpactivity.cats.model.Result>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            when(val response = repository.getCat(FIRST_PAGE )) {
                is ResponseApiCats.Success -> {
                    val data = response.data as Serie
                    data.results.forEach {
                        val fullPath = "https://api.themoviedb.org/3/" +"${it.poster_path}"
                        it.poster_path == fullPath
                    }
                    callback.onResult(data.results, null, FIRST_PAGE + 1)
                }
                is ResponseApiCats.Error -> {
                    callback.onResult(mutableListOf(), null, FIRST_PAGE + 1)
                }
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, dominando.android.apihelpactivity.cats.model.Result>
    ) {
        val page = params.key

        CoroutineScope(Dispatchers.IO).launch {
            when(val response = repository.getCat(page)) {
                is ResponseApiCats.Success -> {
                    val data = response.data as Serie
                    data.results.forEach {
                        val fullPath = "https://api.themoviedb.org/3/" +"${it.poster_path}"
                        it.poster_path == fullPath
                    }
                    callback.onResult(data.results, page + 1)
                }
                is ResponseApiCats.Error -> {
                    callback.onResult(mutableListOf(), page + 1)
                }
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, dominando.android.apihelpactivity.cats.model.Result>
    ) {
        val page = params.key

        CoroutineScope(Dispatchers.IO).launch {
            when(val response = repository.getCat(page)) {
                is ResponseApiCats.Success -> {
                    val data = response.data as Serie
                    data.results.forEach {
                        val fullPath = "https://api.themoviedb.org/3/" +"${it.poster_path}"
                        it.poster_path == fullPath
                    }
                    callback.onResult(data.results, page - 1)
                }
                is ResponseApiCats.Error -> {
                    callback.onResult(mutableListOf(), page - 1)
                }
            }
        }

    }

}