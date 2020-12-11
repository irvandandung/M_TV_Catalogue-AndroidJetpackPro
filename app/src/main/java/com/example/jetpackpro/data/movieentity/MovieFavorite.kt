package com.example.jetpackpro.data.movieentity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class MovieFavorite(
    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    var adult: Boolean?,
    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @ColumnInfo(name = "budget")
    @SerializedName("budget")
    var budget: Int?,
    @ColumnInfo(name = "genres")
    @SerializedName("genres")
    var genres: List<Genre?>?,
    @ColumnInfo(name = "hompage")
    @SerializedName("homepage")
    var homepage: String?,
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int?,
    @ColumnInfo(name = "imdb_id")
    @SerializedName("imdb_id")
    var imdbId: String?,
    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    var originalLanguage: String?,
    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    var originalTitle: String?,
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    var overview: String?,
    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    var popularity: Double?,
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    var posterPath: String?,
    @ColumnInfo(name = "production_companies")
    @SerializedName("production_companies")
    var productionCompanies: List<ProductionCompany?>?,
    @ColumnInfo(name = "production_countries")
    @SerializedName("production_countries")
    var productionCountries: List<ProductionCountry?>?,
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    var releaseDate: String?,
    @ColumnInfo(name = "revenue")
    @SerializedName("revenue")
    var revenue: Int?,
    @ColumnInfo(name = "runtime")
    @SerializedName("runtime")
    var runtime: Int?,
    @ColumnInfo(name = "spoken_languages")
    @SerializedName("spoken_languages")
    var spokenLanguages: List<SpokenLanguage?>?,
    @ColumnInfo(name = "status")
    @SerializedName("status")
    var status: String?,
    @ColumnInfo(name = "tagline")
    @SerializedName("tagline")
    var tagline: String?,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String?,
    @ColumnInfo(name = "video")
    @SerializedName("video")
    var video: Boolean?,
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    var voteAverage: Double?,
    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    var voteCount: Int?
) : Parcelable