package com.example.sub1dicoding.ui.tvshow.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sub1dicoding.data.TvShowsEntity
import com.example.sub1dicoding.utils.DataObject

class TvShowDetailViewModel : ViewModel(){
    private lateinit var tvshowId : String

    fun setSelectedTvShow(tvshowId : String){
        this.tvshowId = tvshowId
    }

    fun getTvShow() : TvShowsEntity{
        lateinit var tvshow : TvShowsEntity
        val tvShowEntities = DataObject.listDataTvShowDummy()
        for (tvShowEntity in tvShowEntities){
            if (tvShowEntity.id == tvshowId){
                tvshow = tvShowEntity
            }
        }
        return tvshow
    }
}