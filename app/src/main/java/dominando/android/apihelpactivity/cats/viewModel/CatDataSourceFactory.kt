package dominando.android.apihelpactivity.cats.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import dominando.android.apihelpactivity.cats.model.Result


class CatDataSourceFactory : DataSource.Factory<Int, dominando.android.apihelpactivity.cats.model.Result>() {

    //creating the mutable live data
    private val tmdbLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, dominando.android.apihelpactivity.cats.model.Result>>()

    override fun create(): DataSource<Int, dominando.android.apihelpactivity.cats.model.Result> {
        //getting our data source object
        val tmdbDataSource = CatPageKeyedDataSource()

        //posting the datasource to get the values
        tmdbLiveDataSource.postValue(tmdbDataSource)

        //returning the datasource
        return tmdbDataSource
    }

    //getter for itemlivedatasource
    fun getSearchLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Result>> {
        return tmdbLiveDataSource
    }
}


