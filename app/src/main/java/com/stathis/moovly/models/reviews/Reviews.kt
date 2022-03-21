package com.stathis.moovly.models.reviews

import com.stathis.moovly.abstraction.MoovlyModel

data class Reviews(
    val id:String,
    val author:String,
    val content:String,
    val url:String
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel): Boolean = false
}
