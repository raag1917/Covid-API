package com.raag.covidapi.domain

import com.raag.covidapi.data.model.CovidData
import retrofit2.http.GET

interface WebServices {

    @GET("8835-5baf.json")
    suspend fun getData(): List<CovidData>

}