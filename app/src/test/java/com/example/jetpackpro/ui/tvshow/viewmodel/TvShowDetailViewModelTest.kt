package com.example.jetpackpro.ui.tvshow.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.utils.DataObjek
import com.example.jetpackpro.vo.Resource
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
    private val dummyTvshow : Resource<TvShow?> = Resource.success(DataObjek.dataDetailTvShow())
    private val tvShowId = dummyTvshow.data?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository : Repository

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShow?>>


    @Before
    fun setUp() {
        viewModel = TvShowDetailViewModel(appRepository)
        tvShowId?.let { viewModel.setSelectedTvShow(it) }
    }

    @Test
    fun getTvShow() {
        val tvshow = MutableLiveData<Resource<TvShow?>>()
        tvshow.value = dummyTvshow

        `when`(tvShowId?.let { appRepository.getDetailTvShow(it) }).thenReturn(tvshow)
        val tvShowEntity = viewModel.getTvShow().value
        tvShowId?.let { verify(appRepository).getDetailTvShow(it) }
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvshow.data?.id, dummyTvshow.data?.id)
        assertEquals(dummyTvshow.data?.originalName, tvShowEntity?.data?.originalName)
        assertEquals(dummyTvshow.data?.backdropPath, tvShowEntity?.data?.backdropPath)
        assertEquals(dummyTvshow.data?.voteAverage, tvShowEntity?.data?.voteAverage)

        viewModel.getTvShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvshow)
    }
}