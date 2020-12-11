package com.example.jetpackpro.ui.tvshow.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.jetpackpro.ui.tvshow.fragment.TvShowFavoriteFragment
import com.example.jetpackpro.ui.tvshow.fragment.TvShowFragment

class SectionsTvShowPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm){
    private var titleTvShow : String = ""
    private var titleTvShowFavoritr : String = ""

    fun setTitle(tvShow : String, tvShowFavorite : String){
        titleTvShow = tvShow
        titleTvShowFavoritr = tvShowFavorite
    }

    private val pages = listOf(
        TvShowFragment(),
        TvShowFavoriteFragment()
    )

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> titleTvShow
            else -> titleTvShowFavoritr
        }
    }

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getCount(): Int = pages.size

}