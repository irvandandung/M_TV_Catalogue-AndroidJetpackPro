package com.example.jetpackpro.data.source

import androidx.lifecycle.LiveData
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.data.tvshowentity.TvShow

interface DataSource {
    //movie
    fun getAllMovies() : LiveData<List<Result>>
    fun getDetailMovies(movieId : Int) : LiveData<Movie>

    //tvshow
    fun getAllTvshow() : LiveData<List<com.example.jetpackpro.data.tvshowentity.Result>>
    fun getDetailTvShow(tvshowid: Int) : LiveData<TvShow>
}