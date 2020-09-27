package co.id.egiwibowo.imovie.movie.presentation.movie_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.egiwibowo.imovie.domain.entities.MovieDetails
import co.id.egiwibowo.imovie.movie.R
import kotlinx.android.synthetic.main.chips.view.*
import java.util.ArrayList

class GenreAdapter : RecyclerView.Adapter<GenreAdapter.ListViewHolder>() {

    private var listData = ArrayList<MovieDetails.Genre>()
    var onItemClick: ((MovieDetails.Genre) -> Unit)? = null

    fun setData(newListData: List<MovieDetails.Genre>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chips, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: MovieDetails.Genre) {
            with(itemView) {
                tv_text.text = data.name
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}