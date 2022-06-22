package com.example.guidedbeertours.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TourItem(
    val Duration_en: String,
    val Groupsize_en: String ="Group size_en",
    val Location: String,
    val Name_en: String,
    val Name_nl: String,
    val Price_en: Int,
    val Price_nl: Int,
    val Website: String,
    val copyrights: String,
    val description_en: String,
    val imagesURL: String,
    val videoURL: String
): Parcelable