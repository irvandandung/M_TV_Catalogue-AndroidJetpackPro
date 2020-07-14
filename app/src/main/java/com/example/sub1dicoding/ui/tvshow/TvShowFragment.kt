package com.example.sub1dicoding.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sub1dicoding.R
import com.example.sub1dicoding.data.TvShowsEntity
import com.example.sub1dicoding.ui.tvshow.viewmodel.TvShowViewModel
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment(), TvShowFragmentCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
        val tvshow = viewModel.getTvShowData()
        val tvShowAdapter = TvShowAdapter(this)
        tvShowAdapter.setTvShow(tvshow)

        with(rv_tvshow){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
    }

    override fun onShareClick(tvshow: TvShowsEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder.from(activity).apply {
                setType(mimeType)
                setChooserTitle("Share M-TV Catalogue now!.")
                setText("Share M-TV Catalogue now!. ${resources.getString(R.string.share_text)} ${tvshow.title}")
                startChooser()
            }
        }
    }
}

interface TvShowFragmentCallback {
    fun onShareClick(tvshow :TvShowsEntity )
}
