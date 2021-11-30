package vp.videoplayer.takeaway
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vp.videoplayer.takeaway.Remote.Api
import vp.videoplayer.takeaway.Remote.Client
import vp.videoplayer.takeaway.Remote.Helper
import vp.videoplayer.takeaway.Remote.Network
import vp.videoplayer.takeaway.Repository.RemoteRepo
import vp.videoplayer.takeaway.VieewModel.MyViewModel
import vp.videoplayer.takeaway.VieewModel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var  responseDTO: vp.videoplayer.takeaway.Response
    private lateinit var list:ArrayList<ResultsItem>
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list= ArrayList()
        //responseDTO=Response()
        val api=Helper.getRetrofit().create(Api::class.java)
        Log.d("TAG","api")
        val repo=RemoteRepo(api)
//        Log.d("TAG","repo")
//
//        CoroutineScope(Dispatchers.IO).launch (){
//            repo.getResult()
//            Log.d("TAG","MyViewModel9")
//        }
        myViewModel= ViewModelProvider(this,MyViewModelFactory(repo)).get(MyViewModel::class.java)
        //myViewModel= MyViewModel(repo)
        myViewModel.results.observe(this,{
            Log.d("TAG",it.title.toString())
           list.add(it)
        })
        //callApi()
    }

    private fun callApi() {
//        var clientApi= Network.getRetrofit().create(Client::class.java)
//        clientApi.getApi("328c283cd27bd1877d9080ccb1604c91").enqueue(object : Callback<vp.videoplayer.takeaway.Response>
//        {
//            override fun onResponse(call: Call<vp.videoplayer.takeaway.Response>, response: Response<vp.videoplayer.takeaway.Response>) {
//                responseDTO=response.body()!!
//                list= responseDTO.results as ArrayList<ResultsItem>
//                Log.d("TAGG","passed"+" "+responseDTO.totalResults+" "+responseDTO.results?.size)
//                setRecycleView()
//            }
//
//            override fun onFailure(call: Call<vp.videoplayer.takeaway.Response>, t: Throwable) {
//                Log.d("TAGG","failed")
//            }
//
//        })
    }

    private fun setRecycleView() {
        var  myAdapter=MyAdapter(list)
        val linearLayoutManager=LinearLayoutManager(this)
        recycler.adapter=myAdapter
        recycler.layoutManager=linearLayoutManager
    }
}