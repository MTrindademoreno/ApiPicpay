package dominando.android.apihelpactivity.cats.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dominando.android.apihelpactivity.cats.Api.ResponseApiCats
import dominando.android.apihelpactivity.cats.Cat
import dominando.android.apihelpactivity.cats.CatBusinness
import dominando.android.apihelpactivity.cats.model.Result
import dominando.android.apihelpactivity.cats.model.Serie
import kotlinx.coroutines.launch

class CatViewModel:ViewModel() {

    var livedataCat :MutableLiveData<Serie> = MutableLiveData()
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    private var  catBusinness = CatBusinness()

    fun getCat(){

        viewModelScope.launch {
            val response =catBusinness.getCat()

            when(response){
                is ResponseApiCats.Success->{
                    livedataCat.postValue(
                        response.data as? Serie
                    )
                }
                is ResponseApiCats.Error ->{
                   errorMessageLiveData.postValue(
                       response.message
                   )


                }
            }
        }


    }
}