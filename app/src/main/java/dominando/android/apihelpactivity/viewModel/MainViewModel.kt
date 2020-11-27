package dominando.android.apihelpactivity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dominando.android.apihelpactivity.ResponseApi
import dominando.android.apihelpactivity.model.Users
import dominando.android.apihelpactivity.model.home.HomeRepository
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    val homeBusinness = HomeRepository()
    val userLiveData:MutableLiveData<Users> = MutableLiveData()
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()

    fun getUsers(){

        viewModelScope.launch {
            val response = homeBusinness.getUsers()

            when(response){
                is ResponseApi.Success ->{
                    userLiveData.postValue(
                        response.data as? Users
                    )
                }
                is ResponseApi.Error ->{
                    errorMessageLiveData.postValue(
                        response.message
                    )

                }
            }

        }

    }
}