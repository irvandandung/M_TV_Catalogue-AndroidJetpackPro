package com.example.sub1dicoding.ui.movie.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {
    private lateinit var viewModel : MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }
    @Test
    fun getMovieData() {
        val movieEntities = viewModel.getMovieData()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}