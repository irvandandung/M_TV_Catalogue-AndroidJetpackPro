package com.example.sub1dicoding.ui.tvshow.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sub1dicoding.data.TvShowsEntity
import com.example.sub1dicoding.utils.DataObject

class TvShowViewModel : ViewModel() {
    fun getTvShowData() : List<TvShowsEntity> = DataObject.listDataTvShowDummy()
}