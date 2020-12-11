package com.example.jetpackpro.ui.movie.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpackpro.BuildConfig
import com.example.jetpackpro.R
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.MovieFavorite
import com.example.jetpackpro.ui.movie.DetailMovieActivity
import com.example.jetpackpro.ui.movie.fragment.MovieFragmentFavoriteCallback
import kotlinx.android.synthetic.main.items_movie.view.*

class MovieFavoriteAdapter (private val callback: MovieFragmentFavoriteCallback) : RecyclerView.Adapter<MovieFavoriteAdapter.MovieFavoriteViewHolder>(){
    private var listMovieFavorite = ArrayList<MovieFavorite>()

    fun setFavoriteMovie(movie: List<MovieFavorite>?) {
        if (movie == null) return
        listMovieFavorite.clear()
        movie.let {
            listMovieFavorite.addAll(it)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieFavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return MovieFavoriteViewHolder(view)
    }

    override fun getItemCount(): Int = listMovieFavorite.size

    override fun onBindViewHolder(
        holder: MovieFavoriteAdapter.MovieFavoriteViewHolder,
        position: Int
    ) {
        val movie = listMovieFavorite[position]
        holder.bind(movie)
    }

    inner class MovieFavoriteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie:MovieFavorite){
            with(itemView){
                tv_item_title.text = movie.title
                tv_item_date.text = movie.releaseDate
                tv_item_status.text = movie.voteAverage.toString()
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
                    .load("${BuildConfig.URL_POSTER}${movie.posterPath}")
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                    .into(img_poster)
            }
        }
    }
}