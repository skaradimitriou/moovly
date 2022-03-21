package com.stathis.moovly.models.cast

import com.stathis.moovly.abstraction.MoovlyModel

data class Cast(
    val cast_id:Int,
    val character :String,
    val credit_id :String,
    val id:Int,
    val name :String,
    val order:Int,
    val profile_path:String
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel) = false
}
