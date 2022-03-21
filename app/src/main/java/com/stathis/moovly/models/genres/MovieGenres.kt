package com.stathis.moovly.models.genres

import com.stathis.moovly.abstraction.MoovlyModel

data class MovieGenres(
    val id: Int,
    val name: String
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel) = false
}
