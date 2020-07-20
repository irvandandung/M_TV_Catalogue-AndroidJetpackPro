package com.example.jetpackpro.ui.tvshow.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.utils.DataObjek
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowDetailViewModelTest {
    private lateinit var viewModel: TvShowDetailViewModel
    private val dummyTvshow = DataObjek.dataDetailTvShow()
    private val tvShowId = dummyTvshow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository : Repository

    @Mock
    private lateinit var tvShowObserver: Observer<TvShow>


    @Before
    fun setUp() {
        viewModel = TvShowDetailViewModel(appRepository)
        tvShowId?.let { viewModel.setSelectedTvShow(it) }
    }

    @Test
    fun getTvShow() {
        val tvshow = MutableLiveData<TvShow>()
        tvshow.value = dummyTvshow

        `when`(tvShowId?.let { appRepository.getDetailTvShow(it) }).thenReturn(tvshow)
        val tvShowEntity = viewModel.getTvShow().value
        tvShowId?.let { verify(appRepository).getDetailTvShow(it) }
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvshow.id, tvShowEntity?.id)
        assertEquals(dummyTvshow.originalName, tvShowEntity?.originalName)
        assertEquals(dummyTvshow.backdropPath, tvShowEntity?.backdropPath)
        assertEquals(dummyTvshow.voteAverage, tvShowEntity?.voteAverage)

        viewModel.getTvShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvshow)
    }
}