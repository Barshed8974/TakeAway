package vp.videoplayer.takeaway.Remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import vp.videoplayer.takeaway.Response

interface Client {
    @GET("3/discover/movie")
    fun getApi(@Query("api_key") api_key: String): Call<Response>
}