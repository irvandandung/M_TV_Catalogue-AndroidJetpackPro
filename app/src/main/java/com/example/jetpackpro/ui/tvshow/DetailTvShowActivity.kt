package com.example.jetpackpro.ui.tvshow

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpackpro.BuildConfig
import com.example.jetpackpro.R
import com.example.jetpackpro.data.source.remote.network.RetrofitBuilder
import com.example.jetpackpro.data.source.remote.network.ApiServices
import com.example.jetpackpro.ui.tvshow.viewmodel.TvShowDetailViewModel
import com.example.jetpackpro.viewmodelfactory.ViewModelFactory
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
        val api = RetrofitBuilder()
            .createservicemovie(ApiServices::class.java)
        val factory = ViewModelFactory.getInstance(this, api)
        val viewModel = ViewModelProvider(this, factory)[TvShowDetailViewModel::class.java]
        val extras = intent.extras
        showLoading(true)
        if (extras != null){
            val tvshowId = extras.getInt(EXTRA_TV_SHOW)
            if (tvshowId != 0){
                viewModel.setSelectedTvShow(tvshowId)
                viewModel.getTvShow().observe(this, Observer { tvshow ->
                    showLoading(false)
                    Glide.with(this)
                    .load("${BuildConfig.URL_POSTER}${tvshow.backdropPath}")
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                    .into(imgBanner)
                    titleDetail.text = tvshow.originalName
                    timeDetail.text = "${tvshow.numberOfEpisodes.toString()} episodes"
                    vote_average.text = tvshow.voteAverage.toString()
                    overview.text = tvshow.overview
                    language.text = tvshow.originalLanguage
                    tanggal.text = tvshow.firstAirDate
                    people_popularity.text = tvshow.popularity.toString()

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
