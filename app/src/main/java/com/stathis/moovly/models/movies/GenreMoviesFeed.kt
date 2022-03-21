package com.stathis.moovly.models.movies

import com.stathis.moovly.abstraction.MoovlyModel

data class GenreMoviesFeed(
    val page:Int,
    val total_results:Int,
    val total_pages:Int,
    val results:List<Movies>
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel): Boolean = false
}