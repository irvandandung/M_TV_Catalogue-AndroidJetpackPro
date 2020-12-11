package com.example.jetpackpro.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.MovieFavorite
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.data.source.local.dao.ConverterDao
import com.example.jetpackpro.data.source.local.dao.EntityDao
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.data.tvshowentity.TvShowFavorite

@Database(entities = [MovieFavorite::class, TvShowFavorite::class, Movie::class, TvShow::class, Result::class, com.example.jetpackpro.data.tvshowentity.Result::class], version = 1)
@TypeConverters(ConverterDao::class)
abstract class TvMovieDatabase : RoomDatabase(){
    abstract fun entityDao() : EntityDao

    companion object{
        @Volatile
        private var INSTANCE : TvMovieDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context) : TvMovieDatabase {
            if (INSTANCE == null){
                synchronized(TvMovieDatabase::class.java){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(context.applicationContext, TvMovieDatabase::class.java, "tv_movie_database").build()
                    }
                }
            }
            return INSTANCE as TvMovieDatabase
        }
    }
}