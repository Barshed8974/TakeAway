package vp.videoplayer.takeaway.Remote

import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query
import vp.videoplayer.takeaway.ResultsItem


interface Api {
    @GET("3/discover/movie?api_key=328c283cd27bd1877d9080ccb1604c91")
    suspend fun getApi() :retrofit2.Response<ResultsItem>
}