package com.stathis.moovly.models.cast

import com.stathis.moovly.abstraction.MoovlyModel

data class MovieCastFeed(
    val id:Int,
    val cast:List<Cast>,
    val crew:List<Crew>
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel) = false
}
