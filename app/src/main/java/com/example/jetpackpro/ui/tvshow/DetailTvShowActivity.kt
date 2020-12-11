package com.example.jetpackpro.ui.tvshow

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpackpro.BuildConfig
import com.example.jetpackpro.R
import com.example.jetpackpro.data.source.remote.network.RetrofitBuilder
import com.example.jetpackpro.data.source.remote.network.ApiServices
import com.example.jetpackpro.data.tvshowentity.TvShowFavorite
import com.example.jetpackpro.ui.tvshow.viewmodel.TvShowDetailViewModel
import com.example.jetpackpro.viewmodelfactory.ViewModelFactory
import com.example.jetpackpro.vo.Status
import kotlinx.android.synthetic.main.activity_detail_tv_show.*

class DetailTvShowActivity : AppCompatActivity() {
    companion object{
        var EXTRA_TV_SHOW = "EXTRA_TV_SHOW"
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title = "Tv Show"
        collapsing_toolbar.setCollapsedTitleTextColor(getColor(R.color.white))
        collapsing_toolbar.setExpandedTitleColor(getColor(R.color.colorPrimary))
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[TvShowDetailViewModel::class.java]
        val extras = intent.extras
        if (extras != null){
            val tvshowId = extras.getInt(EXTRA_TV_SHOW)
            if (tvshowId != 0){
                viewModel.setSelectedTvShow(tvshowId)
                viewModel.getTvShow().observe(this, Observer { tvshow ->
                    if (tvshow != null){
                        when(tvshow.status){
                            Status.LOADING -> showLoading(true)
                            Status.SUCCESS -> {
                                showLoading(false)
                                Glide.with(this)
                                        .load("${BuildConfig.URL_POSTER}${tvshow.data?.backdropPath}")
                                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                                        .into(imgBanner)
                                titleDetail.text = tvshow.data?.originalName
                                timeDetail.text = "${tvshow.data?.numberOfEpisodes.toString()} episodes"
                                vote_average.text = tvshow.data?.voteAverage.toString()
                                overview.text = tvshow.data?.overview
                                language.text = tvshow.data?.originalLanguage
                                tanggal.text = tvshow.data?.firstAirDate
                                people_popularity.text = tvshow.data?.popularity.toString()
                                viewModel.checkFavoriteTvShow(tvshowId).observe(this, Observer { count->
                                    if (isFavorite(count)){
                                        favoriteTap.setImageResource(R.drawable.ic_baseline_star_rate_24)
                                    }
                                    val tvShowFavorite = TvShowFavorite(
                                            backdropPath = tvshow.data?.backdropPath,
                                            createdBy = tvshow.data?.createdBy,
                                            episodeRunTime = tvshow.data?.episodeRunTime,
                                            firstAirDate = tvshow.data?.firstAirDate,
                                            voteAverage = tvshow.data?.voteAverage,
                                            voteCount = tvshow.data?.voteCount,
                                            overview = tvshow.data?.overview,
                                            status = tvshow.data?.status,
                                            seasons = tvshow.data?.seasons,
                                            productionCompanies = tvshow.data?.productionCompanies,
                                            posterPath = tvshow.data?.posterPath,
                                            popularity = tvshow.data?.popularity,
                                            originalLanguage = tvshow.data?.originalLanguage,
                                            name = tvshow.data?.name,
                                            homepage = tvshow.data?.homepage,
                                            languages = tvshow.data?.languages,
                                            lastAirDate = tvshow.data?.lastAirDate,
                                            lastEpisodeToAir = tvshow.data?.lastEpisodeToAir,
                                            numberOfSeasons = tvshow.data?.numberOfSeasons,
                                            originalName = tvshow.data?.originalName,
                                            id = tvshow.data?.id,
                                            inProduction = tvshow.data?.inProduction,
                                            numberOfEpisodes = tvshow.data?.numberOfEpisodes,
                                            networks = tvshow.data?.networks,
                                            genres = tvshow.data?.genres,
                                            originCountry = tvshow.data?.originCountry,
                                            type = tvshow.data?.type
                                    )
                                    favoriteTap.setOnClickListener {
                                        viewModel.getFavoriteTvShow().observe(this, Observer { tvshow ->
                                            Log.d("check data", tvshow.toString())
                                        })
                                        if (!isFavorite(count)){
                                            viewModel.insertFavoriteTvShow(tvShowFavorite)
                                            Toast.makeText(this,"Add ${tvshow.data?.name} to Favorite Tv Show Success", Toast.LENGTH_SHORT).show()
                                            favoriteTap.setImageResource(R.drawable.ic_baseline_star_rate_24)
                                        }else{
                                            viewModel.deleteFavoriteTvShow(tvShowFavorite)
                                            Toast.makeText(this,"Delete ${tvshow.data?.name} from Favorite Tv Show Success", Toast.LENGTH_SHORT).show()
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
