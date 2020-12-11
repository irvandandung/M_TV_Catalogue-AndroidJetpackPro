package com.example.jetpackpro.data.source.local.dao

import androidx.room.TypeConverter
import com.example.jetpackpro.data.movieentity.Genre
import com.example.jetpackpro.data.movieentity.ProductionCompany
import com.example.jetpackpro.data.movieentity.ProductionCountry
import com.example.jetpackpro.data.movieentity.SpokenLanguage
import com.example.jetpackpro.data.tvshowentity.CreatedBy
import com.example.jetpackpro.data.tvshowentity.LastEpisodeToAir
import com.example.jetpackpro.data.tvshowentity.Network
import com.example.jetpackpro.data.tvshowentity.Season
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConverterDao {
    @TypeConverter
    fun fromGenreMovie(value : List<Genre?>?) : String? {
        val type = object : TypeToken<List<Genre>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toGenreMovie(value : String?) : List<Genre?>? {
        val type = object : TypeToken<List<Genre>>() {}.type
        return Gson().fromJson<List<Genre>>(value, type)
    }

    @TypeConverter
    fun fromProductionCompanies(value: List<ProductionCompany?>?) : String? {
        val type = object : TypeToken<List<ProductionCompany>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toProductionCompanies(value: String?): List<ProductionCompany?>? {
        val type = object : TypeToken<List<ProductionCompany>>() {}.type
        return Gson().fromJson<List<ProductionCompany>>(value, type)
    }

    @TypeConverter
    fun fromProductionCountries(value : List<ProductionCountry?>?) : String? {
        val type = object : TypeToken<List<ProductionCountry>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toProductionCountries(value : String?) : List<ProductionCountry?>? {
        val type = object : TypeToken<List<ProductionCountry>>() {}.type
        return Gson().fromJson<List<ProductionCountry>>(value, type)
    }

    @TypeConverter
    fun fromSpokenLanguages(value : List<SpokenLanguage?>?) : String? {
        val type = object : TypeToken<List<SpokenLanguage>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toSpokenLanguages(value : String?) : List<SpokenLanguage?>? {
        val type = object : TypeToken<List<SpokenLanguage>>() {}.type
        return Gson().fromJson<List<SpokenLanguage>>(value, type)
    }

    @TypeConverter
    fun fromCreatedBy(value : List<CreatedBy?>?) : String? {
        val type = object : TypeToken<List<CreatedBy>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toCreatedBy(value : String?) : List<CreatedBy?>? {
        val type = object : TypeToken<List<CreatedBy>>() {}.type
        return Gson().fromJson<List<CreatedBy>>(value, type)
    }

    @TypeConverter
    fun fromGenreTvShow(value : List<com.example.jetpackpro.data.tvshowentity.Genre?>?) : String? {
        val type = object : TypeToken<List<com.example.jetpackpro.data.tvshowentity.Genre>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toGenreTvShow(value : String?) : List<com.example.jetpackpro.data.tvshowentity.Genre?>? {
        val type = object : TypeToken<List<com.example.jetpackpro.data.tvshowentity.Genre>>() {}.type
        return Gson().fromJson<List<com.example.jetpackpro.data.tvshowentity.Genre>>(value, type)
    }

    @TypeConverter
    fun fromLastEps(value : LastEpisodeToAir) : String? {
        val type = object : TypeToken<LastEpisodeToAir>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toLastEps(value : String?) : LastEpisodeToAir {
        val type = object : TypeToken<LastEpisodeToAir>() {}.type
        return Gson().fromJson<LastEpisodeToAir>(value, type)
    }

    @TypeConverter
    fun fromNetwork(value : List<Network?>?) : String? {
        val type = object : TypeToken<List<Network>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toNetwork(value : String?) : List<Network?>? {
        val type = object : TypeToken<List<Network>>() {}.type
        return Gson().fromJson<List<Network>>(value, type)
    }

    @TypeConverter
    fun fromProdCom(value : List<com.example.jetpackpro.data.tvshowentity.ProductionCompany?>?) : String? {
        val type = object : TypeToken<List<com.example.jetpackpro.data.tvshowentity.ProductionCompany>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toProdCom(value : String?) : List<com.example.jetpackpro.data.tvshowentity.ProductionCompany?>? {
        val type = object : TypeToken<List<com.example.jetpackpro.data.tvshowentity.ProductionCompany>>() {}.type
        return Gson().fromJson<List<com.example.jetpackpro.data.tvshowentity.ProductionCompany>>(value, type)
    }

    @TypeConverter
    fun fromSeason(value : List<Season?>?) : String? {
        val type = object : TypeToken<List<Season>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toSeason(value : String?) : List<Season?>? {
        val type = object : TypeToken<List<Season>>() {}.type
        return Gson().fromJson<List<Season>>(value, type)
    }

    @TypeConverter
    fun fromListInt(value : List<Int?>?) : String? {
        val type = object : TypeToken<List<Int>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toListInt(value : String?) : List<Int?>? {
        val type = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson<List<Int>>(value, type)
    }

    @TypeConverter
    fun fromListString(value : List<String?>?) : String? {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toListString(value : String?) : List<String?>? {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson<List<String>>(value, type)
    }
}