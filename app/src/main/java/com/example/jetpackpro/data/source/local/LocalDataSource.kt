package com.example.jetpackpro.data.source.local

import androidx.lifecycle.LiveData
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.MovieFavorite
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.data.source.local.dao.EntityDao
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.data.tvshowentity.TvShowFavorite

class LocalDataSource private constructor(private val entityDao: EntityDao){
    companion object{
        private var INSTANCE : LocalDataSource? = null

        fun getInstance(entityDao: EntityDao): LocalDataSource = INSTANCE ?: LocalDataSource(entityDao)
    }

    //Movie
    fun getAllListMovie(): LiveData<List<Result>?> = entityDao.getAllListMovie()

    fun insertListMovie(movie : Result) = entityDao.insertListMovie(movie)

    fun updateListMovie(movie: Result) = entityDao.updateListMovie(movie)

    fun getDetailMovie(id:Int) : LiveData<Movie?> = entityDao.getDetailMovie(id)

    fun insertDetailMovie(movie: Movie) = entityDao.insertDetailMovie(movie)

    fun updateDetailMovie(movie: Movie) = entityDao.updateDetailMovie(movie)

    fun insertFavoriteMovie(movie : MovieFavorite) = entityDao.insertFavoriteMovie(movie)

    fun deleteFavoriteMovie(movie : MovieFavorite) = entityDao.deleteFavoriteMovie(movie)

    fun getAllFavoriteMovies() = entityDao.getAllFavoriteMovies()

    fun getCountFavoriteMovieById(id: Int) = entityDao.getCountFavoriteMovieById(id)

    //TvShow
    fun getAllListTvShow() : LiveData<List<com.example.jetpackpro.data.tvshowentity.Result>?> = entityDao.getAllListTvShow()

    fun insertListTvShow(tvShow : com.example.jetpackpro.data.tvshowentity.Result) = entityDao.insertListTvShow(tvShow)

    fun updateListTvShow(tvShow: com.example.jetpackpro.data.tvshowentity.Result) = entityDao.updateListTvShow(tvShow)

    fun getDetailTvShow(id :Int) : LiveData<TvShow?> = entityDao.getDetailTvShow(id)

    fun insertDetailTvShow(tvShow: TvShow) = entityDao.insertDetailTvShow(tvShow)

    fun updateDetailTvSHow(tvShow: TvShow) = entityDao.insertDetailTvShow(tvShow)

    fun insertFavoriteTvShow(tvShow: TvShowFavorite) = entityDao.insertFavoriteTvShow(tvShow)

    fun deleteFavoriteTvShow(tvShow: TvShowFavorite) = entityDao.deleteFavoriteTvShow(tvShow)

    fun getAllFavoriteTvShows() = entityDao.getAllFavoriteTvShows()

    fun getCountTvFavoriteShowById(id : Int) = entityDao.getCountTvFavoriteShowById(id)
}