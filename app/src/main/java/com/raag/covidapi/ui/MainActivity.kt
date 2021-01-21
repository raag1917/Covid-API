package com.raag.covidapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.raag.covidapi.adapter.CovidAdapter
import com.raag.covidapi.data.DataSource
import com.raag.covidapi.databinding.ActivityMainBinding
import com.raag.covidapi.domain.RepoImpl
import com.raag.covidapi.ui.viewmodel.MainViewModel
import com.raag.covidapi.ui.viewmodel.VMFactory
import com.raag.covidapi.vo.Resource

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupAdapter()
    }

    private fun setupAdapter() {
        viewModel.fetchCodesList.observe(this@MainActivity, { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.loading.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.loading.visibility = View.GONE
                    binding.recyclerView.adapter = CovidAdapter(this, result.data)
                }
                is Resource.Failure -> {
                    binding.loading.visibility = View.GONE
                    Toast.makeText(
                        this@MainActivity,
                        "Error al cargar datos: ${result.exception}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
    }

    private fun setupViewModel() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}