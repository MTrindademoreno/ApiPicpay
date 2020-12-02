package dominando.android.apihelpactivity.tmdb.home

import dominando.android.apihelpactivity.tmdb.ApiService
import dominando.android.apihelpactivity.tmdb.ResponseApi

class HomeRepository {
    suspend fun getTopRated(): ResponseApi {
        val response = ApiService.topRated.topRated()
        return try {


            if (response.isSuccessful) {
                ResponseApi.Success(response.body())
            } else {
                ResponseApi.Error("Erro ao carregar os dados")

            }

        } catch (exception: Exception) {
            ResponseApi.Error("Erro ao carregar os dados")
        }
    }


}