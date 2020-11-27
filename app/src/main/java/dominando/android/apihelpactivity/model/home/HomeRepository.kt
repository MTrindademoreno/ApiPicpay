package dominando.android.apihelpactivity.model.home

import dominando.android.apihelpactivity.ApiService
import dominando.android.apihelpactivity.ResponseApi

class HomeRepository {
    suspend fun getUsers(): ResponseApi {
        val response = ApiService.picpayApi.users()
        return try {

            val response = ApiService.picpayApi.users()
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