package dominando.android.apihelpactivity.cats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dominando.android.apihelpactivity.R
import dominando.android.apihelpactivity.cats.model.Result

class CatsAdapter() : PagedListAdapter<Result, CatsAdapter.ViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatsAdapter.ViewHolder, position: Int) {
        val result :Result?= getItem(position)
        holder.bind(result)
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(serie: Result?) = with(itemView) {
            findViewById<TextView>(R.id.tvNameUser).text = serie?.name
            val url = "https://image.tmdb.org/t/p/w500/" + "${serie?.poster_path}"
            Glide.with(context).load(url).into(findViewById<ImageView>(R.id.imgPhotoUser))
        }

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

        }

    }
}