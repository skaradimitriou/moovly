package com.stathis.moovly.models.series

import com.stathis.moovly.abstraction.MoovlyModel

data class TvSeriesFeed(
    val page:Int,
    val total_results:Int,
    val total_pages:Int,
    val results:List<TvSeries>
) : MoovlyModel {
    override fun equalsContent(obj: MoovlyModel): Boolean = false
}