package dominando.android.apihelpactivity.cats.Api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatApiService {
    val catApi = getCatApi().create(CatApi::class.java)

    fun getCatApi(): Retrofit {

            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


    }
}