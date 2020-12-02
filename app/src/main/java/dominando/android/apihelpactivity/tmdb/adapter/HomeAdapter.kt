package dominando.android.apihelpactivity.tmdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dominando.android.apihelpactivity.R
import dominando.android.apihelpactivity.tmdb.home.Result
import dominando.android.apihelpactivity.tmdb.home.TopRated

class HomeAdapter(val list: TopRated) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.results[position])
    }

    override fun getItemCount(): Int {
        return list.results.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: Result) = with(itemView) {
        findViewById<TextView>(R.id.tvNameUser).text = result.title
val url = "https://image.tmdb.org/t/p/w500/"+ "${result.poster_path}"
            Glide.with(context).load(url).into(findViewById<ImageView>(R.id.imgPhotoUser))
        }

    }
}