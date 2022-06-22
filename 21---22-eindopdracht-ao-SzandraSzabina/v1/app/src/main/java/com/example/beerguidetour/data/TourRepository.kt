package com.example.beerguidetour.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.beerguidetour.R
import com.example.beerguidetour.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class TourRepository(val app: Application)
{
    val tourData = MutableLiveData<List<Tour>>()

    private val listType = Types.newParameterizedType(
        List::class.java, Tour::class.java)

    init
    {
        getTourData()
    }

    fun getTourData(){
        val text = FileHelper.getTextFromResources(app, R.raw.beer_guidedtours)
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<Tour>> =
            moshi.adapter(listType)
        tourData.value = adapter.fromJson(text) ?: emptyList()
    }

}