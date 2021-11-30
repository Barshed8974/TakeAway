package vp.videoplayer.takeaway

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class MyHolder(private  val itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(responseDTO: ResultsItem)
    {
        itemView.apply {
            itemView.tv1.text=responseDTO.title
        }
    }
}