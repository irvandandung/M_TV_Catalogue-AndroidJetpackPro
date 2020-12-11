package com.example.jetpackpro.data.tvshowentity


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "detailtvshow")
@Parcelize
data class TvShow(
    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @ColumnInfo(name = "created_by")
    @SerializedName("created_by")
    var createdBy: List<CreatedBy?>?,
    @ColumnInfo(name = "episode_run_time")
    @SerializedName("episode_run_time")
    var episodeRunTime: List<Int?>?,
    @ColumnInfo(name = "first_air_date")
    @SerializedName("first_air_date")
    var firstAirDate: String?,
    @ColumnInfo(name = "genres")
    @SerializedName("genres")
    var genres: List<Genre?>?,
    @ColumnInfo(name = "homepage")
    @SerializedName("homepage")
    var homepage: String?,
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int?,
    @ColumnInfo(name = "in_production")
    @SerializedName("in_production")
    var inProduction: Boolean?,
    @ColumnInfo(name = "languages")
    @SerializedName("languages")
    var languages: List<String?>?,
    @ColumnInfo(name = "last_air_date")
    @SerializedName("last_air_date")
    var lastAirDate: String?,
    @ColumnInfo(name = "last_episode_to_air")
    @SerializedName("last_episode_to_air")
    var lastEpisodeToAir: LastEpisodeToAir?,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String?,
    @ColumnInfo(name = "networks")
    @SerializedName("networks")
    var networks: List<Network?>?,
    @ColumnInfo(name = "number_of_episodes")
    @SerializedName("number_of_episodes")
    var numberOfEpisodes: Int?,
    @ColumnInfo(name = "number_of_seasons")
    @SerializedName("number_of_seasons")
    var numberOfSeasons: Int?,
    @ColumnInfo(name = "origin_country")
    @SerializedName("origin_country")
    var originCountry: List<String?>?,
    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    var originalLanguage: String?,
    @ColumnInfo(name = "original_name")
    @SerializedName("original_name")
    var originalName: String?,
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
    @ColumnInfo(name = "seasons")
    @SerializedName("seasons")
    var seasons: List<Season?>?,
    @ColumnInfo(name = "status")
    @SerializedName("status")
    var status: String?,
    @ColumnInfo(name = "type")
    @SerializedName("type")
    var type: String?,
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    var voteAverage: Double?,
    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    var voteCount: Int?
) : Parcelable