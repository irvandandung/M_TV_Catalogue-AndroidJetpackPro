package com.example.jetpackpro.data.source

import androidx.lifecycle.LiveData
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.MovieFavorite
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.data.source.local.LocalDataSource
import com.example.jetpackpro.data.source.remote.ApiResponse
import com.example.jetpackpro.data.source.remote.RemoteDataSource
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.data.tvshowentity.TvShowFavorite
import com.example.jetpackpro.utils.AppExecutors
import com.example.jetpackpro.vo.Resource
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Repository private constructor(private val remoteDataSource: RemoteDataSource,
                                     private val localDataSource: LocalDataSource,
                                     private val appExecutors: AppExecutors) : DataSourceRepository{
    companion object{
        @Volatile
        private var instance : Repository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): Repository =
            instance ?: synchronized(this){
                instance ?: Repository(remoteData, localData , appExecutors)
            }
    }
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    //movie
    override fun getAllMovies(): LiveData<Resource<List<Result>?>> {
        return object : NetworkBoundResource<List<Result>?, List<Result>?>(appExecutors){
            public override fun loadFromDB(): LiveData<List<Result>?> {
                return localDataSource.getAllListMovie()
            }

            override fun shouldFetch(data: List<Result>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<Result>?>> {
                return remoteDataSource.getAllMovies()
            }

            override fun saveCallResult(data: List<Result>?) {
                if (data != null) {
                    for (response in data){
                        localDataSource.insertListMovie(response)
                    }
                }
            }
        }.asLiveData()
    }
    override fun getDetailMovies(movieId: Int): LiveData<Resource<Movie?>> {
        return object : NetworkBoundResource<Movie?, Movie?>(appExecutors){
            override fun loadFromDB(): LiveData<Movie?> {
                return localDataSource.getDetailMovie(movieId)
            }

            override fun shouldFetch(data: Movie?): Boolean {
                return data?.id == null
            }

            override fun createCall(): LiveData<ApiResponse<Movie?>> {
                return remoteDataSource.getDetailMovie(movieId)
            }

            override fun saveCallResult(data: Movie?) {
                data?.let { localDataSource.insertDetailMovie(it) }
            }

        }.asLiveData()
    }
    override fun getAllFavoriteMovies(): LiveData<List<MovieFavorite>> = localDataSource.getAllFavoriteMovies()
    override fun getCountMovieById(id: Int): LiveData<Int> = localDataSource.getCountFavoriteMovieById(id)
    override fun insertFavoriteMovie(movie: MovieFavorite) = executorService.execute { localDataSource.insertFavoriteMovie(movie) }
    override fun deleteFavoriteMovie(movie: MovieFavorite) = executorService.execute { localDataSource.deleteFavoriteMovie(movie) }

    //tv show
    override fun getAllTvshow(): LiveData<Resource<List<com.example.jetpackpro.data.tvshowentity.Result>?>>{
        return object : NetworkBoundResource<List<com.example.jetpackpro.data.tvshowentity.Result>?, List<com.example.jetpackpro.data.tvshowentity.Result>?>(appExecutors){
            override fun loadFromDB(): LiveData<List<com.example.jetpackpro.data.tvshowentity.Result>?> {
                return localDataSource.getAllListTvShow()
            }

            override fun shouldFetch(data: List<com.example.jetpackpro.data.tvshowentity.Result>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<com.example.jetpackpro.data.tvshowentity.Result>?>> {
                return remoteDataSource.getAllTvShow()
            }

            override fun saveCallResult(data: List<com.example.jetpackpro.data.tvshowentity.Result>?) {
                if (data != null) {
                    for (response in data) {
                        localDataSource.insertListTvShow(response)
                    }
                }
            }

        }.asLiveData()
    }
    override fun getDetailTvShow(tvshowid: Int): LiveData<Resource<TvShow?>> {
        return object : NetworkBoundResource<TvShow?, TvShow?>(appExecutors){
            override fun loadFromDB(): LiveData<TvShow?> {
                return localDataSource.getDetailTvShow(tvshowid)
            }

            override fun shouldFetch(data: TvShow?): Boolean {
                return data?.id == null
            }

            override fun createCall(): LiveData<ApiResponse<TvShow?>> {
                return remoteDataSource.getDetailTv(tvshowid)
            }

            override fun saveCallResult(data: TvShow?) {
                data?.let { localDataSource.insertDetailTvShow(it) }
            }

        }.asLiveData()
    }
    override fun getAllFavoriteTvShow(): LiveData<List<TvShowFavorite>> = localDataSource.getAllFavoriteTvShows()
    override fun getCountTvShowById(id: Int): LiveData<Int> = localDataSource.getCountTvFavoriteShowById(id)
    override fun insertFavoriteTvShow(tvShow: TvShowFavorite) = executorService.execute { localDataSource.insertFavoriteTvShow(tvShow) }
    override fun deleteFavoriteTvShow(tvShow: TvShowFavorite) = executorService.execute { localDataSource.deleteFavoriteTvShow(tvShow) }

}