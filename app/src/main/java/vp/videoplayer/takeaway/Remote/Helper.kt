package vp.videoplayer.takeaway.Remote


import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Helper {
    fun getRetrofit(): Retrofit {
        Log.d("TAG","Helper")
        return Retrofit.Builder()
            .baseUrl(" https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}