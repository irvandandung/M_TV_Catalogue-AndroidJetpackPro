package com.example.sub1dicoding.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.sub1dicoding.R
import com.example.sub1dicoding.utils.DataObject
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    private val movieData = DataObject.listDataMovieDummy()
    private val tvshowData = DataObject.listDataTvShowDummy()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movieData.size))
    }

    @Test
    fun loadMovieDetail(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
        onView(withId(R.id.titleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.titleDetail)).check(matches(withText(movieData[5].title)))
    }

    @Test
    fun loadTvShows(){
        onView(withText("LIST TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvshowData.size))
    }

    @Test
    fun loadTvShowDetail(){
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.titleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.titleDetail)).check(matches(withText(tvshowData[0].title)))
    }
}