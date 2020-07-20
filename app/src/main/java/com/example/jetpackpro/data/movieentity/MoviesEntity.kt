package com.example.jetpackpro.data.movieentity


import com.google.gson.annotations.SerializedName

data class MoviesEntity(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var results: List<Result>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)