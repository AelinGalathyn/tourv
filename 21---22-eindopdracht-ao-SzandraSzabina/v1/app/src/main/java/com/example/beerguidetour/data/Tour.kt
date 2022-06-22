package com.example.beerguidetour.data

import com.squareup.moshi.Json

data class Tour(
    val Name_nl: String? = null,
    val Name_en: String? = null,
    val Location: String? = null,
    val Website: String? = null,
    val description_nl: String? = null,
    val description_en: String? = null,
    val Duration_en: String? = null,
    val Duration_nl: String? = null,
    @Json(name = "Group size_en") val Groupsize_en: String? = null,
    val Groupsize_nl: String? = null,
    val Price_en: String? = null,
    val Price_nl: String? = null,
    val Languages: String? = null,
    val imagesURL: String? = null,
    val videoURL: String? = null,
    val copyrights: String? = null,
    @Json(name = "Related links") val Relatedlinks: String? = null,
    val Changed_time: Int? = null,
    val Deleted: Int? = null
)
