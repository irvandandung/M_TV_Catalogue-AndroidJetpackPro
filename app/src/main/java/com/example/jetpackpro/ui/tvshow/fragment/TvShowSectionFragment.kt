package com.example.jetpackpro.ui.tvshow.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jetpackpro.R
import com.example.jetpackpro.ui.tvshow.adapter.SectionsTvShowPagerAdapter
import kotlinx.android.synthetic.main.fragment_tv_show_section.view.*

class TvShowSectionFragment : Fragment() {
    private lateinit var sectionsTvShowPagerAdapter: SectionsTvShowPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tv_show_section, container, false)
        sectionsTvShowPagerAdapter = SectionsTvShowPagerAdapter(childFragmentManager)
        sectionsTvShowPagerAdapter.setTitle(getString(R.string.tv_show_title), getString(R.string.tv_show_favorite_tile))
        root.view_pager_tv.adapter = sectionsTvShowPagerAdapter
        root.tabs_main.setupWithViewPager(root.view_pager_tv)
        return root
    }
}