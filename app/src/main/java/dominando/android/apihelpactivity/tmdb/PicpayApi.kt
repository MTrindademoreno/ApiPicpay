package dominando.android.apihelpactivity.tmdb

import dominando.android.apihelpactivity.tmdb.home.TopRated
import retrofit2.Response
import retrofit2.http.GET

interface PicpayApi {
    @GET("movie/top_rated?api_key=b22fbd2072291603b45de1accc451712&language=en-US&page=1")
    suspend fun topRated(): Response<TopRated>
}