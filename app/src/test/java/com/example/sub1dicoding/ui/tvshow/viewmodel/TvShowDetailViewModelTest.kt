package com.example.sub1dicoding.ui.tvshow.viewmodel

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TvShowDetailViewModelTest {
    private lateinit var viewModel: TvShowDetailViewModel

    @Before
    fun setUp() {
        viewModel = TvShowDetailViewModel()
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow("1")
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertNotNull(tvShowEntity.imagePath)
        assertNotNull(tvShowEntity.episode)
        assertNotNull(tvShowEntity.original_language)
        assertNotNull(tvShowEntity.overview)
        assertNotNull(tvShowEntity.session)
        assertNotNull(tvShowEntity.title)
    }
}