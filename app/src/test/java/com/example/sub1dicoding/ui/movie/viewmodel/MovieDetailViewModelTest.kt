package com.example.sub1dicoding.ui.movie.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieDetailViewModelTest {
    private lateinit var viewModel: MovieDetailViewModel

    @Before
    fun setUp(){
        viewModel = MovieDetailViewModel()
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie("1")
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertNotNull(movieEntity.imagePath)
        assertNotNull(movieEntity.original_language)
        assertNotNull(movieEntity.overview)
        assertNotNull(movieEntity.status)
        assertNotNull(movieEntity.time)
        assertNotNull(movieEntity.title)
    }
}