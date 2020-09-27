package co.id.egiwibowo.imovie.movie.presentation.movie_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import co.id.egiwibowo.imovie.movie.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_movie.view.*
import java.util.ArrayList

class RecommendMovieAdapter : RecyclerView.Adapter<RecommendMovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<MovieDetails.RecommendMovie>()
    var onItemClick: ((MovieDetails.RecommendMovie) -> Unit)? = null

    fun setData(newListData: List<MovieDetails.RecommendMovie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_movie, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: MovieDetails.RecommendMovie) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500"+data.posterPath)
                    .into(image)
                tv_title.text = data.title
                tv_rating.text = "${data.rating}/10"
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}