package com.stathis.moovly.models.genres

import com.stathis.moovly.abstraction.MoovlyModel

data class MovieGenresFeed(
    val genres:List<MovieGenres>
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel): Boolean = false
}
