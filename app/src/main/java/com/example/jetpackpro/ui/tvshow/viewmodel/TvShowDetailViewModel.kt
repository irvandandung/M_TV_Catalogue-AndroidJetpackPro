package com.example.jetpackpro.ui.tvshow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.data.tvshowentity.TvShowFavorite
import com.example.jetpackpro.vo.Resource

class TvShowDetailViewModel(private val appRepository: Repository) : ViewModel(){
    private var tvshowId : Int = 0

    fun setSelectedTvShow(tvshowId : Int){
        this.tvshowId = tvshowId
    }

    fun getTvShow() : LiveData<Resource<TvShow?>> =  appRepository.getDetailTvShow(tvshowId)

    fun getFavoriteTvShow() = appRepository.getAllFavoriteTvShow()

    fun insertFavoriteTvShow(tvShow: TvShowFavorite) = appRepository.insertFavoriteTvShow(tvShow)

    fun deleteFavoriteTvShow(tvShow: TvShowFavorite) = appRepository.deleteFavoriteTvShow(tvShow)

    fun checkFavoriteTvShow(id : Int) = appRepository.getCountTvShowById(id)
}