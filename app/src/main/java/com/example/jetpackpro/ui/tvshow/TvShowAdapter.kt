package com.example.jetpackpro.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpackpro.BuildConfig
import com.example.jetpackpro.R
import com.example.jetpackpro.data.tvshowentity.Result
import kotlinx.android.synthetic.main.items_tvshow.view.*

class TvShowAdapter(private var callback : TvShowFragmentCallback) : RecyclerView.Adapter<TvShowAdapter.tvshowViewHolder>(){
    private var listTvShow = ArrayList<Result>()

    fun setTvShow(tvshow : List<Result>?){
        if(tvshow == null) return
        listTvShow.clear()
        listTvShow.addAll(tvshow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tvshowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tvshow, parent, false)
        return tvshowViewHolder(view)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: tvshowViewHolder, position: Int) {
        val tvshow = listTvShow[position]
        holder.bind(tvshow)
    }

    inner class tvshowViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvshow : Result){
            with(itemView){
                tv_item_title.text = tvshow.name
                tv_item_originallangueage.text = tvshow.voteAverage.toString()
                tv_item_session.text = tvshow.firstAirDate
                setOnClickListener {
                    val intent = Intent(context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvshow.id)
                    }
                    context.startActivity(intent)
                }
                img_share.setOnClickListener {
                    callback.onShareClick(tvshow)
                }
                Glide.with(context)
                    .load("${BuildConfig.URL_POSTER}${tvshow.posterPath}")
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                    .into(img_poster)
            }
        }
    }
}