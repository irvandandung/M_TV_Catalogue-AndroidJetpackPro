package com.example.sub1dicoding.ui.tvshow

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sub1dicoding.R
import com.example.sub1dicoding.ui.tvshow.viewmodel.TvShowDetailViewModel
import kotlinx.android.synthetic.main.activity_detail_tv_show.*

class DetailTvShowActivity : AppCompatActivity() {
    companion object{
        var EXTRA_TV_SHOW = "EXTRA_TV_SHOW"
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title = "Tv Show"
        collapsing_toolbar.setCollapsedTitleTextColor(getColor(R.color.white))
        collapsing_toolbar.setExpandedTitleColor(getColor(R.color.colorPrimary))

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowDetailViewModel::class.java]
        val extras = intent.extras
        if (extras != null){
            val tvshowId = extras.getString(EXTRA_TV_SHOW)
            if (tvshowId != null){
                viewModel.setSelectedTvShow(tvshowId)
                val tvshow = viewModel.getTvShow()
                Glide.with(this)
                    .load(tvshow.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                    .into(imgBanner)
                titleDetail.text = tvshow.title
                timeDetail.text = tvshow.session
                statusDetail.text = tvshow.episode
                overviewDetail.text = tvshow.overview
                originalLanguageDetail.text = tvshow.original_language
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
