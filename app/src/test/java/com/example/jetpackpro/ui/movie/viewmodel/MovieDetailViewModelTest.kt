package com.example.jetpackpro.ui.movie.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.source.Repository
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
class MovieDetailViewModelTest {
    private lateinit var viewModel:MovieDetailViewModel
    private val dummyMovie : Resource<Movie?> = Resource.success(DataObjek.dataDetailMovieDummy())
    private val movieId = dummyMovie.data?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: Repository

    @Mock
    private lateinit var movieObserver: Observer<Resource<Movie?>>


    @Before
    fun setUp() {
        viewModel = MovieDetailViewModel(appRepository)
        movieId?.let { viewModel.setSelectedMovie(it) }
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<Resource<Movie?>>()
        movie.value = dummyMovie

        `when`(movieId?.let { appRepository.getDetailMovies(it) }).thenReturn(movie)
        val movieEntity = viewModel.getMovie().value
        movieId?.let { verify(appRepository).getDetailMovies(it) }
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.data?.id, movieEntity?.data?.id)
        assertEquals(dummyMovie.data?.posterPath, movieEntity?.data?.posterPath)
        assertEquals(dummyMovie.data?.backdropPath, movieEntity?.data?.backdropPath)
        assertEquals(dummyMovie.data?.title, movieEntity?.data?.title)
        assertEquals(dummyMovie.data?.releaseDate, movieEntity?.data?.releaseDate)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }
}