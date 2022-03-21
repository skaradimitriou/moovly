package com.stathis.moovly.models.cast

import com.stathis.moovly.abstraction.MoovlyModel

data class Crew(
    val credit_id:String,
    val department:String,
    val gender: Int,
    val id:Int,
    val job:String,
    val name:String,
    val profile_path:String
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel) = false
}
