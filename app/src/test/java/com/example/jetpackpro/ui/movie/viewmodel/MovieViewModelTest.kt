package com.example.jetpackpro.ui.movie.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.data.source.Repository
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
class MovieViewModelTest {
    private lateinit var viewModel : MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<List<Result>?>>

    @Before
    fun setUp(){
        viewModel = MovieViewModel(appRepository)
    }

    @Test
    fun getMovieData() {
        val dummyMovies : Resource<List<Result>?> = Resource.success(DataObjek.listDataMovieDummy())
        val movies = MutableLiveData<Resource<List<Result>?>>()
        movies.value = dummyMovies

        `when`(appRepository.getAllMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovieData().value
        verify<Repository>(appRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(2, movieEntities?.data?.size)

        viewModel.getMovieData().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}