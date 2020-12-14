package com.example.jetpackpro.ui.tvshow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackpro.R
import com.example.jetpackpro.data.tvshowentity.TvShowFavorite
import com.example.jetpackpro.ui.tvshow.adapter.TvShowFavoriteAdapter
import com.example.jetpackpro.ui.tvshow.viewmodel.TvShowViewModel
import com.example.jetpackpro.viewmodelfactory.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_show.*
import kotlinx.android.synthetic.main.fragment_tv_show_favorite.*

class TvShowFavoriteFragment : Fragment(), TvShowFavoriteFragmentCallback{
    private lateinit var factory: ViewModelFactory
    private lateinit var viewModel: TvShowViewModel
    private lateinit var tvShowFavoriteAdapter: TvShowFavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
        tvShowFavoriteAdapter = TvShowFavoriteAdapter(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            showLoading(true)
            viewModel.getTvShowFavoriteData().observe(this.viewLifecycleOwner, Observer { tvshowFavorite ->
                showLoading(false)
                tvShowFavoriteAdapter.setTvShowFavorite(tvshowFavorite)
                with(rv_tvshow_favorite){
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = tvShowFavoriteAdapter
                }
            })
        }
    }

    override fun onShareClick(tvShow: TvShowFavorite) {
        if (activity != null) {
            val mimeType = "text/plain"
            this.activity?.let {
                ShareCompat.IntentBuilder.from(it).apply {
                    setType(mimeType)
                    setChooserTitle("Share M-TV Catalogue now!.")
                    setText("Share M-TV Catalogue now!. ${resources.getString(R.string.share_text)} ${tvShow.name}")
                    startChooser()
                }
            }
        }
    }

    private fun showLoading(state : Boolean){
        if (state){
            progress_bar_favorite.visibility = View.VISIBLE
        }else{
            progress_bar_favorite.visibility = View.GONE
        }
    }
}

interface TvShowFavoriteFragmentCallback{
    fun onShareClick(tvShow: TvShowFavorite)
}