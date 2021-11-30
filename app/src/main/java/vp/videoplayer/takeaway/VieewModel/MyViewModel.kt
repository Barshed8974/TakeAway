package vp.videoplayer.takeaway.VieewModel

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vp.videoplayer.takeaway.Repository.RemoteRepo
import vp.videoplayer.takeaway.ResultsItem

class MyViewModel(private val repo:RemoteRepo): ViewModel() {

    val results:MutableLiveData<ResultsItem> = MutableLiveData<ResultsItem>()
    init {
        viewModelScope.launch (Dispatchers.IO){
            repo.getResult().let {
                if(it.isSuccessful){
                    results.postValue(it.body())
                }
            }
        }
    }
}