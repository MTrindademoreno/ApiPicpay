package dominando.android.apihelpactivity.cats.Api

import dominando.android.apihelpactivity.cats.model.Serie
import retrofit2.Response
import retrofit2.http.GET

interface CatApi {

    @GET("tv/popular?api_key=b22fbd2072291603b45de1accc451712&language=en-US&page=1")
    suspend fun getSerie ():Response<Serie>

}
