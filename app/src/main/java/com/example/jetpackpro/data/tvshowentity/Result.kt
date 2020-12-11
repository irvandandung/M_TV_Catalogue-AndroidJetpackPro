package com.example.jetpackpro.data.tvshowentity


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "listtvshow")
@Parcelize
data class Result(
    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    var backdropPath: String?,
    @SerializedName("first_air_date")
    @ColumnInfo(name = "first_air_date")
    var firstAirDate: String?,
    @SerializedName("genre_ids")
    @ColumnInfo(name = "genre_ids")
    var genreIds: List<Int?>?,
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Int?,
    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: String?,
    @SerializedName("origin_country")
    @ColumnInfo(name = "origin_country")
    var originCountry: List<String?>?,
    @SerializedName("original_language")
    @ColumnInfo(name = "original_language")
    var originalLanguage: String?,
    @SerializedName("original_name")
    @ColumnInfo(name = "original_name")
    var originalName: String?,
    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    var overview: String?,
    @SerializedName("popularity")
    @ColumnInfo(name = "popularity")
    var popularity: Double?,
    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    var posterPath: String?,
    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    var voteAverage: Double?,
    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    var voteCount: Int?
) : Parcelable