package com.example.sub1dicoding.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sub1dicoding.R
import com.example.sub1dicoding.data.MovieEntity
import kotlinx.android.synthetic.main.items_movie.view.*

class MovieAdapter(private val callback : MovieFragmentCallback) : RecyclerView.Adapter<MovieAdapter.movieViewHolder>(){
    private  var listMovie = ArrayList<MovieEntity>()

    fun setMovie(movie : List<MovieEntity>?){
        if (movie == null) return
        listMovie.clear()
        movie?.let { listMovie.addAll(it) }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): movieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return movieViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieAdapter.movieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    inner class movieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie : MovieEntity){
            with(itemView){
                tv_item_title.text = movie.title
                tv_item_date.text = movie.time
                tv_item_status.text = movie.status
                setOnClickListener {
                    val intent = Intent(context, DetailMovieActivity::class.java).apply {
                        putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.id)
                    }
                    context.startActivity(intent)
                }
                img_share.setOnClickListener {
                    callback.onShareClick(movie)
                }
                Glide.with(context)
                    .load(movie.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                    .into(img_poster)
            }
        }
    }

}