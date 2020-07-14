package com.example.sub1dicoding.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sub1dicoding.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var sectionsPagerAdapter : SectionsPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sectionsPagerAdapter =  SectionsPagerAdapter(supportFragmentManager)
        sectionsPagerAdapter.setTitle(getString(R.string.moviee), getString(R.string.tvshow))
        view_pager.adapter = sectionsPagerAdapter
        tabs_main.setupWithViewPager(view_pager)
    }
}
