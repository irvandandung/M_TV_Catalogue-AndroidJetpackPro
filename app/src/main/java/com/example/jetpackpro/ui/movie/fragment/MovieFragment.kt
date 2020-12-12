package com.example.jetpackpro.ui.movie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackpro.R
import com.example.jetpackpro.data.movieentity.Result
import com.example.jetpackpro.ui.movie.adapter.MovieAdapter
import com.example.jetpackpro.ui.movie.viewmodel.MovieViewModel
import com.example.jetpackpro.viewmodelfactory.ViewModelFactory
import com.example.jetpackpro.vo.Status
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment(),
    MovieFragmentCallback {

    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter : MovieAdapter
    private lateinit var factory : ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        movieAdapter = MovieAdapter(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            viewModel.getMovieData().observe(this.viewLifecycleOwner, Observer { movie ->
                if (movie != null){
                    when(movie.status){
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS -> {
                            showLoading(false)
                            movieAdapter.submitList(movie.data)
                            with(rv_movie){
                                layoutManager = LinearLayoutManager(context)
                                setHasFixedSize(true)
                                adapter = movieAdapter
                            }
                        }
                        Status.ERROR -> {
                            showLoading(false)
                            Toast.makeText(requireContext().applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
    }

    override fun onShareClick(movie: Result) {
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

    private fun showLoading(state: Boolean){
        if (state){
            progress_bar.visibility = View.VISIBLE
        }else{
            progress_bar.visibility = View.GONE
        }
    }
}

interface MovieFragmentCallback {
    fun onShareClick(movie : Result)
}
