package dominando.android.apihelpactivity.cats

import dominando.android.apihelpactivity.cats.Api.CatApiService
import dominando.android.apihelpactivity.cats.Api.ResponseApiCats

class CatRepository {

    suspend fun getCat(pageNumber:Int):ResponseApiCats{
        return try {
            val response= CatApiService.catApi.getSerie()
            if (response.isSuccessful){
                ResponseApiCats.Success(response.body())
            }else{
                ResponseApiCats.Error(response.message())
            }

        }catch (exception:Exception){
           return ResponseApiCats.Error("Erro ao carregar dados!!")
        }
    }
}