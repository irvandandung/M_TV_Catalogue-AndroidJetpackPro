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
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.ui.movie.DetailMovieActivity
import com.example.jetpackpro.ui.movie.fragment.MovieFragmentCallback
import kotlinx.android.synthetic.main.items_movie.view.*

class MovieAdapter(private val callback : MovieFragmentCallback) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    private var listMovie = ArrayList<Result>()

    fun setMovie(movie : List<Result>?){
        if (movie == null) return
        listMovie.clear()
        movie.let { listMovie.addAll(it) }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    inner class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie : Result){
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

