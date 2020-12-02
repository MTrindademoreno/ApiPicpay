package dominando.android.apihelpactivity.tmdb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dominando.android.apihelpactivity.tmdb.ResponseApi
import dominando.android.apihelpactivity.tmdb.home.HomeBusinness
import dominando.android.apihelpactivity.tmdb.home.TopRated
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    val homeBusinness = HomeBusinness()
    val userLiveData:MutableLiveData<TopRated> = MutableLiveData()
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()

    fun getTopRated(){

        viewModelScope.launch {
            val response = homeBusinness.getTopRated()

            when(response){
                is ResponseApi.Success ->{
                    userLiveData.postValue(
                        response.data as? TopRated
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