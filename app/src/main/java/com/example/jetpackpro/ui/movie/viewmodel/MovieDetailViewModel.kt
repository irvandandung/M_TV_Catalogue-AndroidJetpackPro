package com.example.jetpackpro.ui.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.source.Repository

class MovieDetailViewModel(private val appRepository: Repository) : ViewModel(){
    private var movieId : Int = 0

    fun setSelectedMovie(movieId : Int){
        this.movieId = movieId
    }

    fun getMovie() : LiveData<Movie> = appRepository.getDetailMovies(movieId)
}