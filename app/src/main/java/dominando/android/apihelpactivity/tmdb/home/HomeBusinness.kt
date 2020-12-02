package dominando.android.apihelpactivity.tmdb.home

import dominando.android.apihelpactivity.tmdb.ResponseApi

class HomeBusinness {

    private val repository by lazy {
        HomeRepository()
    }

    suspend fun getTopRated(): ResponseApi {
        return repository.getTopRated()

    }
}