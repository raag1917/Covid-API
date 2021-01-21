package com.raag.covidapi.domain

import com.raag.covidapi.data.model.CovidData
import com.raag.covidapi.data.DataSource
import com.raag.covidapi.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {

    override suspend fun getCodes(): Resource<List<CovidData>> {
        return dataSource.getCodeByName()
    }

}