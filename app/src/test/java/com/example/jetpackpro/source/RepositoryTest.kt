package com.example.jetpackpro.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.jetpackpro.data.movieentity.Movie
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.data.source.local.LocalDataSource
import com.example.jetpackpro.data.source.remote.RemoteDataSource
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.utils.AppExecutors
import com.example.jetpackpro.utils.DataObjek
import com.example.jetpackpro.utils.LiveDataTestUtil
import com.example.jetpackpro.utils.PagedListUtil
import com.example.jetpackpro.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class RepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val movieResponse = DataObjek.listDataMovieDummy()
    private val tvShowResponse = DataObjek.listDataTvShowDummy()
    private val movieDetail = DataObjek.dataDetailMovieDummy()
    private val tvShowDetail = DataObjek.dataDetailTvShow()
    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val repository = FakeRepository(remote, local, appExecutors)

    @Test
    fun getAllMovie(){
        val dataMovieSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Result>
//        val dummyMovies = MutableLiveData<List<Result>?>()
//        dummyMovies.value = DataObjek.listDataMovieDummy()
        Mockito.`when`(local.getAllListMovie()).thenReturn(dataMovieSourceFactory)
        repository.getAllMovies()

        val moviesEntity = Resource.success(DataObjek.listDataMovieDummy()?.let {
            PagedListUtil.mockPagedList(
                it
            )
        })
        verify(local).getAllListMovie()
        assertNotNull(moviesEntity.data)
        assertEquals(movieResponse?.size?.toLong(), moviesEntity.data?.size?.toLong())
    }

    @Test
    fun getAllTvShow(){
        val dataTvShowSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, com.example.jetpackpro.data.tvshowentity.Result>
//        val dummyTvShow = MutableLiveData<List<com.example.jetpackpro.data.tvshowentity.Result>?>()
//        dummyTvShow.value = DataObjek.listDataTvShowDummy()
        Mockito.`when`(local.getAllListTvShow()).thenReturn(dataTvShowSourceFactory)
        repository.getAllTvshow()

        val tvShowEntity = Resource.success(DataObjek.listDataTvShowDummy())
        verify(local).getAllListTvShow()
        assertNotNull(tvShowEntity.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie(){
        val dummyDetailMovie = MutableLiveData<Movie?>()
        dummyDetailMovie.value = DataObjek.dataDetailMovieDummy()
        Mockito.`when`(movieDetail?.id?.let { local.getDetailMovie(it) }).thenReturn(dummyDetailMovie)
        val movieDetailEntity = movieDetail?.id?.let { repository.getDetailMovies(it) }?.let { LiveDataTestUtil.getValue(it) }
        movieDetail?.id?.let { verify(local).getDetailMovie(it) }
        assertNotNull(movieDetailEntity?.data)
        assertEquals(movieDetail?.id, movieDetailEntity?.data?.id)
    }

    @Test
    fun getDetailTvShow(){
        val dummyDetailTvShow = MutableLiveData<TvShow?>()
        dummyDetailTvShow.value = DataObjek.dataDetailTvShow()
        Mockito.`when`(tvShowDetail?.id?.let { local.getDetailTvShow(it) }).thenReturn(dummyDetailTvShow)
        val tvDetailEntity = tvShowDetail?.id?.let { repository.getDetailTvShow(it) }?.let { LiveDataTestUtil.getValue(it) }
        movieDetail?.id?.let { verify(local).getDetailTvShow(it) }
        assertNotNull(tvDetailEntity?.data)
        assertEquals(tvShowDetail?.id, tvDetailEntity?.data?.id)
    }
}