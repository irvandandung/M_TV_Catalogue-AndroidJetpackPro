package com.example.jetpackpro.ui.tvshow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.data.tvshowentity.TvShow

class TvShowDetailViewModel(private val appRepository: Repository) : ViewModel(){
    private var tvshowId : Int = 0

    fun setSelectedTvShow(tvshowId : Int){
        this.tvshowId = tvshowId
    }

    fun getTvShow() : LiveData<TvShow> =  appRepository.getDetailTvShow(tvshowId)
}