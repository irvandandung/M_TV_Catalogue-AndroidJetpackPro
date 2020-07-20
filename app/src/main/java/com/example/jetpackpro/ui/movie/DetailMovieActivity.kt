package com.example.jetpackpro.ui.movie

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpackpro.BuildConfig
import com.example.jetpackpro.R
import com.example.jetpackpro.data.source.remote.network.RetrofitBuilder
import com.example.jetpackpro.data.source.remote.network.ApiServices
import com.example.jetpackpro.ui.movie.viewmodel.MovieDetailViewModel
import com.example.jetpackpro.viewmodelfactory.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        var EXTRA_MOVIE = "EXTRA_MOVIE"
    }
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title = "Movie"
        collapsing_toolbar.setCollapsedTitleTextColor(getColor(R.color.white))
        collapsing_toolbar.setExpandedTitleColor(getColor(R.color.colorPrimary))
        val api = RetrofitBuilder()
            .createservicemovie(ApiServices::class.java)
        val factory = ViewModelFactory.getInstance(this, api)
        val viewModel = ViewModelProvider(this, factory)[MovieDetailViewModel::class.java]
        val extras = intent.extras
        showLoading(true)
        if(extras != null){
            val movieId = extras.getInt(EXTRA_MOVIE)
            if (movieId != 0){
                viewModel.setSelectedMovie(movieId)
                viewModel.getMovie().observe(this, Observer { movie ->
                    showLoading(false)
                    Glide.with(this)
                    .load("${BuildConfig.URL_POSTER}${movie.backdropPath}")
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                    .into(imgBanner)
                    titleDetail.text = movie.title
                    overview.text = movie.overview
                    timeDetail.text = "${movie.runtime.toString()} minutes"
                    vote_average.text = movie.voteAverage.toString()
                    tanggal.text = movie.releaseDate
                    people_popularity.text = movie.popularity.toString()
                    language.text = movie.originalLanguage
                })
            }
        }
    }

    private fun showLoading(state:Boolean){
        if (state){
            progress_bar.visibility = View.VISIBLE
        }else{
            progress_bar.visibility = View.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
