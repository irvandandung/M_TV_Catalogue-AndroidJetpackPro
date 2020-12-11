package com.example.jetpackpro.ui.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.MovieFavorite
import com.example.jetpackpro.data.source.Repository

class MovieDetailViewModel(private val appRepository: Repository) : ViewModel(){
    private var movieId : Int = 0

    fun setSelectedMovie(movieId : Int){
        this.movieId = movieId
    }

    fun getMovie() : LiveData<com.example.jetpackpro.vo.Resource<Movie?>> = appRepository.getDetailMovies(movieId)

    fun insertMovieToFavorite(movie: MovieFavorite) = appRepository.insertFavoriteMovie(movie)

    fun getAllFavoriteMovie() = appRepository.getAllFavoriteMovies()

    fun deleteMovieFromFavorite(movie: MovieFavorite) = appRepository.deleteFavoriteMovie(movie)

    fun checkFavoriteMovie(id : Int) = appRepository.getCountMovieById(id)
}