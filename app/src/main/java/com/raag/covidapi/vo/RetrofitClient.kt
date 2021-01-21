package com.raag.covidapi.vo

import com.google.gson.GsonBuilder
import com.raag.covidapi.domain.WebServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.datos.gov.co/resource/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebServices::class.java)
    }
}