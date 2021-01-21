package com.raag.covidapi.data

import com.raag.covidapi.data.model.CovidData
import com.raag.covidapi.vo.Resource
import com.raag.covidapi.vo.RetrofitClient

class DataSource {
    suspend fun getCodeByName (): Resource<List<CovidData>> {
        return Resource.Success(RetrofitClient.webservice.getData())
    }
}