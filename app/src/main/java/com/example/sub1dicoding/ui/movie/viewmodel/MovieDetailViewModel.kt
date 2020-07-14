package com.example.sub1dicoding.ui.movie.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sub1dicoding.data.MovieEntity
import com.example.sub1dicoding.utils.DataObject

class MovieDetailViewModel : ViewModel(){
    private lateinit var movieId : String

    fun setSelectedMovie(movieId : String){
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity{
        lateinit var movie : MovieEntity
        val movieEntities = DataObject.listDataMovieDummy()
        for (movieEntity in movieEntities){
            if (movieEntity.id == movieId){
                movie = movieEntity
            }
        }
        return movie
    }
}