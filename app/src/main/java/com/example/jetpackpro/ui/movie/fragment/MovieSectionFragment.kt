package com.example.jetpackpro.ui.movie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jetpackpro.R
import com.example.jetpackpro.ui.movie.adapter.SectionsMoviePagerAdapter
import kotlinx.android.synthetic.main.fragment_movie_section.*
import kotlinx.android.synthetic.main.fragment_movie_section.view.*

class MovieSectionFragment : Fragment() {
    private lateinit var sectionsMoviePagerAdapter : SectionsMoviePagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_movie_section, container, false)
        // Inflate the layout for this fragment
        sectionsMoviePagerAdapter =
            SectionsMoviePagerAdapter(
                childFragmentManager
            )
        sectionsMoviePagerAdapter.setTitle(getString(R.string.moviee), getString(R.string.favorite_movie_title))
        root.view_pager.adapter = sectionsMoviePagerAdapter
        root.tabs_main.setupWithViewPager(root.view_pager)
        return root
    }
}