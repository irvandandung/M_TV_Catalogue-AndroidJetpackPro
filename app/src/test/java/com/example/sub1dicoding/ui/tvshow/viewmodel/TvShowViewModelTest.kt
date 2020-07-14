package com.example.sub1dicoding.ui.tvshow.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp(){
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShowData() {
        val tvshowEntities = viewModel.getTvShowData()
        assertNotNull(tvshowEntities)
        assertEquals(10, tvshowEntities.size)
    }
}