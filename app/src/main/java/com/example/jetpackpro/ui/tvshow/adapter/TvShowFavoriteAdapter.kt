package com.example.jetpackpro.ui.tvshow.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpackpro.BuildConfig
import com.example.jetpackpro.R
import com.example.jetpackpro.data.tvshowentity.TvShow
import com.example.jetpackpro.data.tvshowentity.TvShowFavorite
import com.example.jetpackpro.ui.tvshow.DetailTvShowActivity
import com.example.jetpackpro.ui.tvshow.fragment.TvShowFavoriteFragmentCallback
import kotlinx.android.synthetic.main.items_tvshow.view.*

class TvShowFavoriteAdapter(private val callback: TvShowFavoriteFragmentCallback) : RecyclerView.Adapter<TvShowFavoriteAdapter.TvShowFavoriteViewHolder>(){
    private var listTvShowFavorite = ArrayList<TvShowFavorite>()

    fun setTvShowFavorite(tvShow: List<TvShowFavorite>){
        if(tvShow == null) return
        listTvShowFavorite.clear()
        listTvShowFavorite.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowFavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tvshow, parent, false)
        return TvShowFavoriteViewHolder(view)
    }

    override fun getItemCount(): Int = listTvShowFavorite.size

    override fun onBindViewHolder(holder: TvShowFavoriteViewHolder, position: Int) {
        val tvShow = listTvShowFavorite[position]
        holder.bind(tvShow)
    }

    inner class TvShowFavoriteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShowFavorite){
            with(itemView){
                tv_item_title.text = tvShow.name
                tv_item_originallangueage.text = tvShow.voteAverage.toString()
                tv_item_session.text = tvShow.firstAirDate
                setOnClickListener {
                    val intent = Intent(context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShow.id)
                    }
                    context.startActivity(intent)
                }
                img_share.setOnClickListener {
                    callback.onShareClick(tvShow)
                }
                Glide.with(context)
                    .load("${BuildConfig.URL_POSTER}${tvShow.posterPath}")
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
                    .into(img_poster)
            }
        }
    }
}