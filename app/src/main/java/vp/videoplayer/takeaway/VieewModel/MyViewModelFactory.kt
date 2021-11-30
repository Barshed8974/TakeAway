package vp.videoplayer.takeaway.VieewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vp.videoplayer.takeaway.Repository.RemoteRepo

class MyViewModelFactory(private  val repo:RemoteRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d("TAG","MyViewModelFactory")
        return MyViewModel(repo) as T
    }
}