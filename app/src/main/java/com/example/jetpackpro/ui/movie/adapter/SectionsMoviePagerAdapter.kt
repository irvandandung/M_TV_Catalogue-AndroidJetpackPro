package com.example.jetpackpro.ui.movie.adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.jetpackpro.ui.movie.fragment.MovieFavoriteFragment
import com.example.jetpackpro.ui.movie.fragment.MovieFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsMoviePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private var titleMovie : String = ""
    private var titleMovieFavorite : String = ""

    private val pages = listOf(
            MovieFragment(),
            MovieFavoriteFragment()
    )

    fun setTitle(movie:String, movieFavorite:String){
        titleMovie = movie
        titleMovieFavorite = movieFavorite
    }

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getPageTitle(position: Int) : CharSequence? {
        return when (position) {
            0 -> titleMovie
            else -> titleMovieFavorite
        }
    }

    override fun getCount(): Int = pages.size

}
