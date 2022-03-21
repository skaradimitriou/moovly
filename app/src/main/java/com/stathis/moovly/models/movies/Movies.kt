package com.stathis.moovly.models.movies

import com.stathis.moovly.abstraction.MoovlyModel

data class Movies(
    val id:Int,
    val video:Boolean,
    val vote_count:Int,
    val name:String,
    val vote_average:Double,
    val title: String,
    val release_date:String,
    val original_language:String,
    val original_title:String,
    val genre_ids: List<Int>,
    val backdrop_path:String,
    val adult:Boolean,
    val overview:String,
    val poster_path:String,
    val popularity:Double,
    val media_type: String
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel): Boolean = false
}