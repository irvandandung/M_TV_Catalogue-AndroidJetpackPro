package com.example.jetpackpro.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackpro.R
import com.example.jetpackpro.data.source.remote.network.RetrofitBuilder
import com.example.jetpackpro.data.source.remote.network.ApiServices
import com.example.jetpackpro.data.tvshowentity.Result
import com.example.jetpackpro.ui.tvshow.viewmodel.TvShowViewModel
import com.example.jetpackpro.viewmodelfactory.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment(), TvShowFragmentCallback {
    private lateinit var factory: ViewModelFactory
    private lateinit var viewModel: TvShowViewModel
    private lateinit var tvShowAdapter: TvShowAdapter
    private lateinit var api : ApiServices


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        api = RetrofitBuilder()
            .createservicemovie(ApiServices::class.java)
        factory = ViewModelFactory.getInstance(requireContext(), api)
        viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
        tvShowAdapter = TvShowAdapter(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            showLoading(true)
            viewModel.getTvShowData().observe(this.viewLifecycleOwner, Observer { tvshow ->
                showLoading(false)
                tvShowAdapter.setTvShow(tvshow)
                with(rv_tvshow){
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = tvShowAdapter
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
