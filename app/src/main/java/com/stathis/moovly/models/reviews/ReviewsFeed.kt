package com.stathis.moovly.models.reviews

import com.stathis.moovly.abstraction.MoovlyModel

data class ReviewsFeed(
    val id: Int,
    val page: Int,
    val results: List<Reviews>,
    val total_pages: Int,
    val total_results: Int
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel): Boolean = false
}
