package com.example.jetpackpro.ui.tvshow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.data.tvshowentity.Result
import com.example.jetpackpro.vo.Resource

class TvShowViewModel(private val appRepository: Repository) : ViewModel() {
    fun getTvShowData() : LiveData<Resource<List<Result>?>> = appRepository.getAllTvshow()

    fun getTvShowFavoriteData() = appRepository.getAllFavoriteTvShow()
}