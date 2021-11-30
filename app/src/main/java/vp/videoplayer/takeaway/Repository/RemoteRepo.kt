package vp.videoplayer.takeaway.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import vp.videoplayer.takeaway.Remote.Api
import vp.videoplayer.takeaway.ResultsItem

class RemoteRepo(private var client: Api) {


    suspend fun getResult():Response<ResultsItem>
    {
        return client.getApi()


    }
}