package com.example.jetpackpro.ui.tvshow.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.jetpackpro.data.source.Repository
import com.example.jetpackpro.data.tvshowentity.Result
import com.example.jetpackpro.utils.DataObjek
import com.example.jetpackpro.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<Result>?>>

    @Mock
    private lateinit var pagedList: PagedList<Result>

    @Before
    fun setUp(){
        viewModel = TvShowViewModel(appRepository)
    }

    @Test
    fun getTvShowData() {
        val dummyTvShows : Resource<PagedList<Result>?> = Resource.success(pagedList)
        `when`(dummyTvShows.data?.size).thenReturn(1)
        val tvshow = MutableLiveData<Resource<PagedList<Result>?>>()
        tvshow.value = dummyTvShows

        `when`(appRepository.getAllTvshow()).thenReturn(tvshow)
        val tvshowsEntities = viewModel.getTvShowData().value
        verify<Repository>(appRepository).getAllTvshow()
        assertNotNull(tvshowsEntities)
        assertEquals(1, tvshowsEntities?.data?.size)

        viewModel.getTvShowData().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}