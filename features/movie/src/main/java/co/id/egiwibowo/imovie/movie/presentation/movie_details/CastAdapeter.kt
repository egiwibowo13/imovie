package co.id.egiwibowo.imovie.movie.presentation.movie_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import co.id.egiwibowo.imovie.movie.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_actor.view.*
import kotlinx.android.synthetic.main.card_actor.view.image
import java.util.ArrayList

class CastAdapeter : RecyclerView.Adapter<CastAdapeter.ListViewHolder>() {

    private var listData = ArrayList<MovieDetails.Cast>()
    var onItemClick: ((MovieDetails.Cast) -> Unit)? = null

    fun setData(newListData: List<MovieDetails.Cast>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_actor, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: MovieDetails.Cast) {
            with(itemView) {
                if (data.profilePath != null) {
                    Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w500"+data.profilePath)
                        .into(image)
                }
                tv_name.text = data.name
                tv_caracter.text = data.character
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}