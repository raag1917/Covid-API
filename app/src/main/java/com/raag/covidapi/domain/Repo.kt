package com.raag.covidapi.domain

import com.raag.covidapi.data.model.CovidData
import com.raag.covidapi.vo.Resource

interface Repo {

    suspend fun getCodes(): Resource<List<CovidData>>
}