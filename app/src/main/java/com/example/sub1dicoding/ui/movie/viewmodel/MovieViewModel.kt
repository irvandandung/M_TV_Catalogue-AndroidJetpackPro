package com.example.sub1dicoding.ui.movie.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sub1dicoding.data.MovieEntity
import com.example.sub1dicoding.utils.DataObject

class MovieViewModel : ViewModel() {
    fun getMovieData() : List<MovieEntity> = DataObject.listDataMovieDummy()
}