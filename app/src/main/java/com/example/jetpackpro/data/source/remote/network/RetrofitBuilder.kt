package com.example.jetpackpro.data.source.remote.network

import com.example.jetpackpro.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    fun <T> createservicemovie(mClass: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(mClass)
    }
}