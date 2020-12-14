package com.example.jetpackpro.ui.movie.fragment

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
import com.example.jetpackpro.data.movieentity.MovieFavorite
import com.example.jetpackpro.ui.movie.adapter.MovieFavoriteAdapter
import com.example.jetpackpro.ui.movie.viewmodel.MovieViewModel
import com.example.jetpackpro.viewmodelfactory.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_movie_favorite.*

class MovieFavoriteFragment : Fragment(),
    MovieFragmentFavoriteCallback {
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieFavoriteAdapter : MovieFavoriteAdapter
    private lateinit var factory : ViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        movieFavoriteAdapter = MovieFavoriteAdapter(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            showLoading(true)
            viewModel.getAllFavoriteMovie().observe(this.viewLifecycleOwner, Observer {movieFavorit ->
                movieFavoriteAdapter.setFavoriteMovie(movieFavorit)
                with(rv_movie_favorite){
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = movieFavoriteAdapter
                }
                showLoading(false)
            })
        }
    }

    private fun showLoading(state: Boolean){
        if (state){
            progress_bar_favorite.visibility = View.VISIBLE
        }else{
            progress_bar_favorite.visibility = View.GONE
        }
    }

    override fun onShareClick(movie: MovieFavorite) {
        if (activity != null) {
            val mimeType = "text/plain"
            this.activity?.let {
                ShareCompat.IntentBuilder.from(it).apply {
                    setType(mimeType)
                    setChooserTitle("Share M-TV Catalogue now!.")
                    setText("Share M-TV Catalogue now!. ${resources.getString(R.string.share_text)} ${movie.title}")
                    startChooser()
                }
            }
        }
    }
}

interface MovieFragmentFavoriteCallback{
    fun onShareClick(movie:MovieFavorite)
}