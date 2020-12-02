package dominando.android.apihelpactivity.cats.viewModel

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import dominando.android.apihelpactivity.cats.model.Result

class CatViewModel:ViewModel() {


    var moviePagedList: LiveData<PagedList<Result>>? = null
    private var tmdbLiveDataSource: LiveData<PageKeyedDataSource<Int, Result>>? = null

    init {
        val catDataSourceFactory = CatDataSourceFactory()

        tmdbLiveDataSource = catDataSourceFactory.getSearchLiveDataSource()

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_SIZE).build()

        moviePagedList = LivePagedListBuilder(catDataSourceFactory, pagedListConfig)
            .build()
    }}