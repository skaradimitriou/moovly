package com.stathis.moovly.models.actor

import com.stathis.moovly.abstraction.MoovlyModel

data class Actor(

    val adult: Boolean,
    val biography: String,
    val birthday: String,
    val known_for_department: String,
    val popularity: Double,
    val also_known_as : List<String>,
    val id: Int,
    val name: String,
    val place_of_birth: String,
    val profile_path: String

) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel) = false
}