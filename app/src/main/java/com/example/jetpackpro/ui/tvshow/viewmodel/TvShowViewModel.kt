package com.example.jetpackpro.ui.tvshow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.data.tvshowentity.Result

class TvShowViewModel(private val appRepository: Repository) : ViewModel() {
    fun getTvShowData() : LiveData<List<Result>> = appRepository.getAllTvshow()
}