package com.example.jetpackpro.ui.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.vo.Resource

class MovieViewModel(private val appRepository: Repository) : ViewModel() {
    fun getMovieData() : LiveData<Resource<List<Result>?>> = appRepository.getAllMovies()

    fun getAllFavoriteMovie() = appRepository.getAllFavoriteMovies()
}