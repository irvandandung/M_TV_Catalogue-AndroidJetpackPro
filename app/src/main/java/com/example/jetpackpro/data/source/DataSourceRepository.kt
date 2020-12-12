package com.example.jetpackpro.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.MovieFavorite
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.data.tvshowentity.TvShowFavorite
import com.example.jetpackpro.vo.Resource

interface DataSourceRepository {
    //movie
    fun getAllMovies() : LiveData<Resource<PagedList<Result>?>>
    fun getDetailMovies(movieId : Int) : LiveData<Resource<Movie?>>
    fun getAllFavoriteMovies() : LiveData<List<MovieFavorite>>
    fun getCountMovieById(id : Int) : LiveData<Int>
    fun insertFavoriteMovie(movie: MovieFavorite)
    fun deleteFavoriteMovie(movie: MovieFavorite)

    //tvshow
    fun getAllTvshow() : LiveData<Resource<PagedList<com.example.jetpackpro.data.tvshowentity.Result>?>>
    fun getDetailTvShow(tvshowid: Int) : LiveData<Resource<TvShow?>>
    fun getAllFavoriteTvShow() : LiveData<List<TvShowFavorite>>
    fun getCountTvShowById(id : Int) : LiveData<Int>
    fun insertFavoriteTvShow(tvShow: TvShowFavorite)
    fun deleteFavoriteTvShow(tvShow: TvShowFavorite)
}