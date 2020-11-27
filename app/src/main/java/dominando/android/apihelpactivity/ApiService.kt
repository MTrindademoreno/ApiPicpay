package dominando.android.apihelpactivity

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val picpayApi = getPicPayClient().create(PicpayApi::class.java )

    private fun getPicPayClient():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://careers.picpay.com/tests/mobdev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}