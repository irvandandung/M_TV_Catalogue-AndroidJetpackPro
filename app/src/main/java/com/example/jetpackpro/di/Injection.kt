package com.example.jetpackpro.di

import android.content.Context
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.data.source.remote.RemoteDataSource
import com.example.jetpackpro.data.source.remote.network.ApiServices

object Injection{
    fun provideRepository(context: Context, api: ApiServices): Repository{

        val remoteDataSource = RemoteDataSource.getInstance(context, api)

        return Repository.getInstance(remoteDataSource)
    }
}