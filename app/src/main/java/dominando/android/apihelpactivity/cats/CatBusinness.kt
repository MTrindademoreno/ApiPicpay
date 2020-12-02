package dominando.android.apihelpactivity.cats

import dominando.android.apihelpactivity.cats.Api.ResponseApiCats

class CatBusinness {
    private val repository : CatRepository by lazy {
        CatRepository()
    }

    suspend fun getCat():ResponseApiCats{

        return repository.getCat()

    }
}