package dominando.android.apihelpactivity.model.home

import dominando.android.apihelpactivity.ResponseApi
import dominando.android.apihelpactivity.model.Users
import dominando.android.apihelpactivity.model.UsersItem

class HomeBusinness {

    private val repository by lazy {
        HomeRepository()
    }

    suspend fun getUsers(): ResponseApi {
        return repository.getUsers()

    }
}