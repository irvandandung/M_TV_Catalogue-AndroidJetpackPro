package com.example.jetpackpro.data.source

import androidx.lifecycle.LiveData
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.data.source.remote.RemoteDataSource
import com.example.jetpackpro.data.tvshowentity.TvShow

class Repository private constructor(private val remoteDataSource: RemoteDataSource) : DataSource{
    companion object{
        @Volatile
        private var instance : Repository? = null

        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this){
                instance ?: Repository(remoteData)
            }
    }

    override fun getAllMovies(): LiveData<List<Result>> = remoteDataSource.getAllMovies()

    override fun getDetailMovies(movieId: Int): LiveData<Movie> = remoteDataSource.getDetailMovie(movieId)

    override fun getAllTvshow(): LiveData<List<com.example.jetpackpro.data.tvshowentity.Result>> = remoteDataSource.getAllTvShow()

    override fun getDetailTvShow(tvshowid: Int): LiveData<TvShow> = remoteDataSource.getDetailTv(tvshowid)
}