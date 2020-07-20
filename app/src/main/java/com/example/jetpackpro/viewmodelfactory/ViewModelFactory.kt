package com.example.jetpackpro.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.data.source.remote.network.ApiServices
import com.example.jetpackpro.di.Injection
import com.example.jetpackpro.ui.movie.viewmodel.MovieDetailViewModel
import com.example.jetpackpro.ui.movie.viewmodel.MovieViewModel
import com.example.jetpackpro.ui.tvshow.viewmodel.TvShowDetailViewModel
import com.example.jetpackpro.ui.tvshow.viewmodel.TvShowViewModel

class ViewModelFactory private constructor(private val appRepository: Repository): ViewModelProvider.NewInstanceFactory(){
    companion object{
        @Volatile
        private var instance : ViewModelFactory? = null

        fun getInstance(context: Context, api:ApiServices) : ViewModelFactory =
            instance ?: synchronized(this){
                instance?: ViewModelFactory(Injection.provideRepository(context, api))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(appRepository) as T
            }
            modelClass.isAssignableFrom(MovieDetailViewModel::class.java)->{
                MovieDetailViewModel(appRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java)->{
                TvShowViewModel(appRepository) as T
            }
            modelClass.isAssignableFrom(TvShowDetailViewModel::class.java)->{
                TvShowDetailViewModel(appRepository) as T
            }
            else -> throw Throwable("Uknown ViewModel Class:" + modelClass.name)
        }
    }
}