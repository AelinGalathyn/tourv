package com.example.guidedtours.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TourItem(
    val Changed_time: Int,
    val Deleted: Int,
    val Duration_en: String,
    val Duration_nl: String,
    val GroupSize_en: String = "Group size-en",
    val GroupSize_nl: String = "Groupsize-nl",
    val Languages: String,
    val Location: String,
    val Name_en: String,
    val Name_nl: String,
    val Price_en: Int,
    val Price_nl: Int,
    val RelatedLinks: String = "Related links",
    val Website: String,
    val copyrights: String,
    val description_en: String,
    val description_nl: String,
    val imagesURL: String,
    val videoURL: String
):Parcelable
