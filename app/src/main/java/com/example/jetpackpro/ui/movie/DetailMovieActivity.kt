package com.example.jetpackpro.ui.movie

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpackpro.BuildConfig
import com.example.jetpackpro.R
import com.example.jetpackpro.data.movieentity.MovieFavorite
import com.example.jetpackpro.data.source.remote.network.RetrofitBuilder
import com.example.jetpackpro.data.source.remote.network.ApiServices
import com.example.jetpackpro.ui.movie.viewmodel.MovieDetailViewModel
import com.example.jetpackpro.viewmodelfactory.ViewModelFactory
import com.example.jetpackpro.vo.Status
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
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[MovieDetailViewModel::class.java]
        val extras = intent.extras
        if(extras != null){
            val movieId = extras.getInt(EXTRA_MOVIE)
            if (movieId != 0){
                viewModel.setSelectedMovie(movieId)
                viewModel.getMovie().observe(this, Observer { movie ->
                    if (movie != null){
                        when(movie.status){
                            Status.LOADING -> showLoading(true)
                            Status.SUCCESS -> {
                                showLoading(false)
                                Glide.with(this)
                                        .load("${BuildConfig.URL_POSTER}${movie.data?.backdropPath}")
                                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                                        .into(imgBanner)
                                titleDetail.text = movie.data?.title
                                overview.text = movie.data?.overview
                                timeDetail.text = "${movie.data?.runtime.toString()} minutes"
                                vote_average.text = movie.data?.voteAverage.toString()
                                tanggal.text = movie.data?.releaseDate
                                people_popularity.text = movie.data?.popularity.toString()
                                language.text = movie.data?.originalLanguage
                                viewModel.checkFavoriteMovie(movieId).observe(this, Observer { count ->
                                    if (isFavorite(count)){
                                        favoriteTap.setImageResource(R.drawable.ic_baseline_star_rate_24)
                                    }
                                    val movieFavorite = MovieFavorite(
                                            adult = movie.data?.adult,
                                            backdropPath = movie.data?.backdropPath,
                                            budget = movie.data?.budget,
                                            genres = movie.data?.genres,
                                            homepage = movie.data?.homepage,
                                            id = movie.data?.id,
                                            imdbId = movie.data?.imdbId,
                                            originalLanguage = movie.data?.originalLanguage,
                                            originalTitle = movie.data?.originalTitle,
                                            overview = movie.data?.overview,
                                            popularity = movie.data?.popularity,
                                            posterPath = movie.data?.posterPath,
                                            productionCompanies = movie.data?.productionCompanies,
                                            productionCountries = movie.data?.productionCountries,
                                            spokenLanguages = movie.data?.spokenLanguages,
                                            releaseDate = movie.data?.releaseDate,
                                            revenue = movie.data?.revenue,
                                            runtime = movie.data?.runtime,
                                            status = movie.data?.status,
                                            tagline = movie.data?.tagline,
                                            title = movie.data?.title,
                                            video = movie.data?.video,
                                            voteAverage = movie.data?.voteAverage,
                                            voteCount = movie.data?.voteCount
                                    )
                                    favoriteTap.setOnClickListener {
                                        viewModel.getAllFavoriteMovie().observe(this, Observer { movie ->
                                            Log.v("testData", movie.toString())
                                        })
                                        if (!isFavorite(count)){
                                            viewModel.insertMovieToFavorite(movieFavorite)
                                            Toast.makeText(this,"Add ${movie.data?.originalTitle} to Favorite Movie Success", Toast.LENGTH_SHORT).show()
                                            favoriteTap.setImageResource(R.drawable.ic_baseline_star_rate_24)
                                        }else{
                                            viewModel.deleteMovieFromFavorite(movieFavorite)
                                            Toast.makeText(this,"Delete ${movie.data?.originalTitle} from Favorite Movie Success", Toast.LENGTH_SHORT).show()
                                            favoriteTap.setImageResource(R.drawable.ic_no_favorite)
                                        }
                                    }
                                })
                            }
                            Status.ERROR -> {
                                showLoading(false)
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
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

    private fun isFavorite(count : Int) : Boolean {
        var isFav = false
        if (count > 0){
            isFav = true
        }
        return isFav
    }
}
