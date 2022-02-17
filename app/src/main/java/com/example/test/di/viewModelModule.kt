package com.example.test.di

import com.example.test.viewmodel.PokeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ PokeViewModel() }
}
