package com.example.sub1dicoding.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sub1dicoding.R
import com.example.sub1dicoding.data.MovieEntity
import com.example.sub1dicoding.ui.movie.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment(), MovieFragmentCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movie = viewModel.getMovieData()
            val movieAdapter = MovieAdapter(this)
            movieAdapter.setMovie(movie)

            with(rv_movie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onShareClick(movie: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder.from(activity).apply {
                setType(mimeType)
                setChooserTitle("Share M-TV Catalogue now!.")
                setText("Share M-TV Catalogue now!. ${resources.getString(R.string.share_text)} ${movie.title}")
                startChooser()
            }
        }
    }
}

interface MovieFragmentCallback {
    fun onShareClick(movie : MovieEntity)
}
