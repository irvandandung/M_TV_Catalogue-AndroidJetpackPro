package com.example.jetpackpro.ui.tvshow.fragment

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
import com.example.jetpackpro.data.tvshowentity.Result
import com.example.jetpackpro.ui.tvshow.adapter.TvShowAdapter
import com.example.jetpackpro.ui.tvshow.viewmodel.TvShowViewModel
import com.example.jetpackpro.viewmodelfactory.ViewModelFactory
import com.example.jetpackpro.vo.Status
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment(),
    TvShowFragmentCallback {
    private lateinit var factory: ViewModelFactory
    private lateinit var viewModel: TvShowViewModel
    private lateinit var tvShowAdapter: TvShowAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
        tvShowAdapter =
            TvShowAdapter(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            viewModel.getTvShowData().observe(this.viewLifecycleOwner, Observer { tvshow ->
                if (tvshow != null){
                    when(tvshow.status){
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS -> {
                            showLoading(false)
                            tvShowAdapter.setTvShow(tvshow.data)
                            with(rv_tvshow){
                                layoutManager = LinearLayoutManager(context)
                                setHasFixedSize(true)
                                adapter = tvShowAdapter
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

    override fun onShareClick(tvshow: Result) {
        if (activity != null) {
            val mimeType = "text/plain"
            this.activity?.let {
                ShareCompat.IntentBuilder.from(it).apply {
                    setType(mimeType)
                    setChooserTitle("Share M-TV Catalogue now!.")
                    setText("Share M-TV Catalogue now!. ${resources.getString(R.string.share_text)} ${tvshow.name}")
                    startChooser()
                }
            }
        }
    }

    private fun showLoading(state : Boolean){
        if (state){
            progress_bar.visibility = View.VISIBLE
        }else{
            progress_bar.visibility = View.GONE
        }
    }
}

interface TvShowFragmentCallback {
    fun onShareClick(tvshow : Result)
}
