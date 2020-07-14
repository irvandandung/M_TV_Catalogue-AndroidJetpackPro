package com.example.sub1dicoding.ui.home
import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sub1dicoding.R
import com.example.sub1dicoding.ui.movie.MovieFragment
import com.example.sub1dicoding.ui.tvshow.TvShowFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private var titleMovie : String = ""
    private var titleTvShow : String = ""

    private val pages = listOf(
        MovieFragment(),
        TvShowFragment()
    )

    fun setTitle(movie:String, tvshow:String){
        titleMovie = movie
        titleTvShow = tvshow
    }

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getPageTitle(position: Int) : CharSequence? {
        return when (position) {
            0 -> titleMovie
            else -> titleTvShow
        }
    }

    override fun getCount(): Int = pages.size

}
