package dominando.android.apihelpactivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dominando.android.apihelpactivity.R
import dominando.android.apihelpactivity.model.UsersItem

class HomeAdapter(val list: List<UsersItem>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(usersItem: UsersItem) = with(itemView) {
        findViewById<TextView>(R.id.tvNameUser).text = usersItem.name
            Glide.with(context).load(usersItem.img).into(findViewById<ImageView>(R.id.imgPhotoUser))
        }

    }
}