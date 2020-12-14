package com.example.jetpackpro.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.jetpackpro.MainActivity
import com.example.jetpackpro.R
import com.example.jetpackpro.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest{

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovies(){
        Thread.sleep(3000)
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
    }

    @Test
    fun loadMovieDetail(){
        Thread.sleep(3000)
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        Thread.sleep(3000)
        onView(withId(R.id.titleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.timeDetail)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavoriteMovies(){
        Thread.sleep(3000)
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        Thread.sleep(3000)
        onView(withId(R.id.favoriteTap)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withText("List Favorite Movie")).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.rv_movie_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.favoriteTap)).perform(click())
    }

    @Test
    fun loadTvShows(){
        onView(withId(R.id.navigation_tv_show)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
    }

    @Test
    fun loadTvShowDetail(){
        onView(withId(R.id.navigation_tv_show)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        Thread.sleep(3000)
        onView(withId(R.id.titleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.timeDetail)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavoriteTvShows(){
        onView(withId(R.id.navigation_tv_show)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        Thread.sleep(3000)
        onView(withId(R.id.favoriteTap)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withText("List Tv Show Favorite")).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.rv_tvshow_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.favoriteTap)).perform(click())
    }
}