package com.stathis.moovly.models.movies

import com.stathis.moovly.abstraction.MoovlyModel

data class UpcomingMovies(
    val results:List<Movies>
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel): Boolean = false
}
