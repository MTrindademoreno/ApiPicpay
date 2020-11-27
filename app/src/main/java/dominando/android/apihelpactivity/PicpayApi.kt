package dominando.android.apihelpactivity

import dominando.android.apihelpactivity.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface PicpayApi {
    @GET("users")
    suspend fun users(): Response<Users>
}