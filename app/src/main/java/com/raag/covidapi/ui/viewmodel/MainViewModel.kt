package com.raag.covidapi.ui.viewmodel

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.raag.covidapi.domain.Repo
import com.raag.covidapi.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: Repo) : ViewModel() {


    val fetchCodesList = liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getCodes())
            } catch (exception: Exception) {
                d("Context", "$exception")
            }
    }


}