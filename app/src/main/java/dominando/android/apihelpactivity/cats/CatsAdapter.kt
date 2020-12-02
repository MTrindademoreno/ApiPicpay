package dominando.android.apihelpactivity.cats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dominando.android.apihelpactivity.R
import dominando.android.apihelpactivity.cats.model.Result
import dominando.android.apihelpactivity.cats.model.Serie

class CatsAdapter(private val lista:Serie):RecyclerView.Adapter<CatsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsAdapter.ViewHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatsAdapter.ViewHolder, position: Int) {
      holder.bind(lista.results[position])
    }

    override fun getItemCount(): Int {
      return lista.results.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(serie:Result)= with(itemView) {
            findViewById<TextView>(R.id.tvNameUser).text = serie.name
            val url = "https://image.tmdb.org/t/p/w500/"+ "${serie.poster_path}"
            Glide.with(context).load(url).into(findViewById<ImageView>(R.id.imgPhotoUser))
        }

    }
}