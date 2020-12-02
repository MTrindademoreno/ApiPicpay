package dominando.android.apihelpactivity.cats.Api

import dominando.android.apihelpactivity.tmdb.ResponseApi

sealed class ResponseApiCats{
    class Success(val data:Any?):ResponseApiCats()
    class Error(val message:String):ResponseApiCats()

}
