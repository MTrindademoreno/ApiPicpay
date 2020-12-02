package dominando.android.apihelpactivity.tmdb

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val topRated = getPicPayClient().create(PicpayApi::class.java )

    private fun getPicPayClient():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}