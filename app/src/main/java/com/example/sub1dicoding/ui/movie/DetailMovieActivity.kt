package com.example.sub1dicoding.ui.movie

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sub1dicoding.R
import com.example.sub1dicoding.ui.movie.viewmodel.MovieDetailViewModel
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        var EXTRA_MOVIE = "EXTRA_MOVIE"
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title = "Movie"
        collapsing_toolbar.setCollapsedTitleTextColor(getColor(R.color.white))
        collapsing_toolbar.setExpandedTitleColor(getColor(R.color.colorPrimary))

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieDetailViewModel::class.java]
        val extras = intent.extras
        if(extras != null){
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null){
                viewModel.setSelectedMovie(movieId)
                val movie = viewModel.getMovie()
                Glide.with(this)
                    .load(movie.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                    .into(imgBanner)
                titleDetail.text = movie.title
                timeDetail.text = movie.time
                statusDetail.text = movie.status
                originalLanguageDetail.text = movie.original_language
                overviewDetail.text = movie.overview
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
