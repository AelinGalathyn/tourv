package com.example.guidedbeertours.data

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import com.example.guidedbeertours.model.TourItem
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


private val BASE_URL = "https://opendata.visitflanders.org/tourist/activities/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
    BASE_URL).build()

interface TourAPIService
{
    @GET("beer_guidedtours.json")
    suspend fun getTourList(): List<TourItem>
}

object TourAPI
{
    val retrofitService: TourAPIService by lazy { retrofit.create(TourAPIService::class.java) }
}
