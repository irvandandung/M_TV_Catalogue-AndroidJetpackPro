package com.example.jetpackpro.di

import android.content.Context
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.data.source.local.LocalDataSource
import com.example.jetpackpro.data.source.local.TvMovieDatabase
import com.example.jetpackpro.data.source.remote.RemoteDataSource
import com.example.jetpackpro.data.source.remote.network.ApiServices
import com.example.jetpackpro.data.source.remote.network.RetrofitBuilder
import com.example.jetpackpro.utils.AppExecutors

object Injection{
    fun provideRepository(context: Context): Repository{
        val api = RetrofitBuilder()
            .createservicemovie(ApiServices::class.java)
        val database = TvMovieDatabase.getDatabase(context)
        val remoteDataSource = RemoteDataSource.getInstance(api)
        val localDataSource = LocalDataSource.getInstance(database.entityDao())
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}