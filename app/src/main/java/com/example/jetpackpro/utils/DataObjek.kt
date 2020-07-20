package com.example.jetpackpro.utils

import com.example.jetpackpro.data.movieentity.*
import com.example.jetpackpro.data.tvshowentity.LastEpisodeToAir
import com.example.jetpackpro.data.tvshowentity.TvShow

object DataObjek {
    fun listDataMovieDummy():List<Result>{
        val movie = ArrayList<Result>()

        movie.add(Result(
            adult = false,
            voteAverage = 7.0,
            voteCount = 249,
            releaseDate = "2000-11-21",
            posterPath = "/AsdB9A2XGalCZVjlyG9tRf03IfW.jpg",
            popularity = 354.456,
            backdropPath = "/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg",
            originalTitle = "Greyhound",
            originalLanguage = "en",
            video = false,
            title = "Greyhound",
            overview = "A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the “Black Pit” to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.",
            genreIds = listOf(28, 18, 10752),
            id = 516486
        ))

        movie.add(Result(
            adult = false,
            voteAverage = 7.0,
            voteCount = 824,
            releaseDate = "2000-11-21",
            posterPath = "/cjr4NWURcVN3gW5FlHeabgBHLrY.jpg",
            popularity = 319.596,
            backdropPath = "/m0ObOaJBerZ3Unc74l471ar8Iiy.jpg",
            originalTitle = "The Old Guard",
            originalLanguage = "en",
            video = false,
            title = "The Old Guard",
            overview = "A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the “Black Pit” to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.",
            genreIds = listOf(28, 18, 10752),
            id = 547016
        ))
        return movie
    }

    fun listDataTvShowDummy(): List<com.example.jetpackpro.data.tvshowentity.Result>{
        val tvShow = ArrayList<com.example.jetpackpro.data.tvshowentity.Result>()

        tvShow.add(com.example.jetpackpro.data.tvshowentity.Result(
            id = 1,
            genreIds = listOf(1,2),
            overview = "asdsdsd",
            originalLanguage = "en",
            voteAverage = 7.0,
            originalName = "Law & Order: Special Victims Unit",
            firstAirDate = "2000-1-2",
            backdropPath = "asds",
            popularity = 121.000,
            posterPath = "asa",
            originCountry = listOf("en","id"),
            voteCount = 12,
            name = "Law & Order: Special Victims Unit"
        ))

        return tvShow
    }

    fun dataDetailMovieDummy() : Movie{
        return Movie(
            id = 516486,
            adult = true,
            voteAverage = 1.4,
            posterPath = "/cjr4NWURcVN3gW5FlHeabgBHLrY.jpg",
            popularity = 12.1,
            backdropPath = "/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg",
            originalLanguage = "en",
            originalTitle = "aa",
            releaseDate = "2020-11-10",
            status = "a",
            homepage = "1",
            productionCompanies = listOf(ProductionCompany(id = null, name = "aaa", logoPath = "aa", originCountry = "aa")),
            budget = 12323,
            spokenLanguages = listOf(SpokenLanguage(iso6391 = "aa", name = "aa")),
            genres = listOf(Genre(id = null,name = "aa")),
            tagline = "aaa",
            imdbId = "aa",
            overview = "aa",
            productionCountries = listOf(ProductionCountry(iso31661 = null, name = "a")),
            title = "aaa",
            video = false,
            runtime = 12,
            voteCount = 12,
            revenue = 12
        )
    }

    fun dataDetailTvShow() : TvShow{
        return TvShow(
            id = 516486,
            voteAverage = 1.4,
            posterPath = "/cjr4NWURcVN3gW5FlHeabgBHLrY.jpg",
            popularity = 12.1,
            backdropPath = "/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg",
            originalLanguage = "en",
            status = "a",
            homepage = "1",
            productionCompanies = listOf(com.example.jetpackpro.data.tvshowentity.ProductionCompany(id = null, logoPath = "", name = "", originCountry = "")),
            genres = listOf(),
            overview = "aa",
            voteCount = 12,
            originCountry = listOf(),
            originalName = "aa",
            numberOfEpisodes = 10,
            numberOfSeasons = 11,
            firstAirDate = "2020-11-1",
            name = "aa",
            createdBy = listOf(),
            languages = listOf(),
            lastAirDate = "2020-11-21",
            lastEpisodeToAir = LastEpisodeToAir(id = null, airDate = "aa", voteAverage = 10, stillPath = "aa", name = "", seasonNumber = 1, episodeNumber = 1, voteCount = 1, overview = "",productionCode = "", showId = 1),
            seasons = listOf(),
            episodeRunTime = listOf(),
            inProduction = true,
            networks = listOf(),
            type = ""
        )
    }


}