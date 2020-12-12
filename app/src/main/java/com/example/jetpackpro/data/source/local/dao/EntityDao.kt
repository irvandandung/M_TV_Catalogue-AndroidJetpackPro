package com.example.jetpackpro.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.MovieFavorite
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.data.tvshowentity.TvShowFavorite

@Dao
interface EntityDao {
    //list movie
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertListMovie(movie : Result)

    @Update
    fun updateListMovie(movie: Result)

    @Query("SELECT * FROM listmovie")
    fun getAllListMovie(): DataSource.Factory<Int, Result>

    //detail movie
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDetailMovie(movie: Movie)

    @Update
    fun updateDetailMovie(movie: Movie)

    @Query("SELECT * FROM detailmovie WHERE id = :id")
    fun getDetailMovie(id : Int) : LiveData<Movie?>

    //favorite
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavoriteMovie(movie: MovieFavorite)

    @Update
    fun updateFavoriteMovie(movie: MovieFavorite)

    @Delete
    fun deleteFavoriteMovie(movie: MovieFavorite)

    @Query("Select * from moviefavorite ORDER by id ASC")
    fun getAllFavoriteMovies(): LiveData<List<MovieFavorite>>

    @Query("Select COUNT(*) from moviefavorite WHERE id = :id")
    fun getCountFavoriteMovieById(id : Int) : LiveData<Int>


    //list tv show
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertListTvShow(tvShow : com.example.jetpackpro.data.tvshowentity.Result)

    @Update
    fun updateListTvShow(tvShow: com.example.jetpackpro.data.tvshowentity.Result)

    @Query("SELECT * FROM listtvshow")
    fun getAllListTvShow(): DataSource.Factory<Int, com.example.jetpackpro.data.tvshowentity.Result>

    //detail tv show
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDetailTvShow(tvShow: TvShow)

    @Update
    fun updateDetailTvShow(tvShow: TvShow)

    @Query("SELECT * FROM detailtvshow WHERE id = :id")
    fun getDetailTvShow(id: Int): LiveData<TvShow?>

    //favorite tv show
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavoriteTvShow(tvShow: TvShowFavorite)

    @Update
    fun updateFavoriteTvShow(tvShow: TvShowFavorite)

    @Delete
    fun deleteFavoriteTvShow(tvShow: TvShowFavorite)

    @Query("Select * from tvshowfavorite ORDER by id ASC")
    fun getAllFavoriteTvShows(): LiveData<List<TvShowFavorite>>

    @Query("Select COUNT(*) from tvshowfavorite WHERE id = :id")
    fun getCountTvFavoriteShowById(id : Int):LiveData<Int>
}