package com.example.jetpackpro.data.source.remote.network

import com.example.jetpackpro.BuildConfig
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.MoviesEntity
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.data.tvshowentity.TvShowsEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    //Movies
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apikey: String = BuildConfig.TSDB_API_KEY,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<MoviesEntity>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apikey: String = BuildConfig.TSDB_API_KEY,
        @Query("language") language: String
    ): Call<Movie>

    @GET("tv/popular")
    fun getPopularTV(
        @Query("api_key") apikey: String = BuildConfig.TSDB_API_KEY,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<TvShowsEntity>

    @GET("tv/{tv_id}")
    fun getDetailTV(
        @Path("tv_id") tv_id: Int,
        @Query("api_key") apikey: String = BuildConfig.TSDB_API_KEY,
        @Query("language") language: String
    ): Call<TvShow>
}