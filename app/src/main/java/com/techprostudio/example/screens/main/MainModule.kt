package com.techprostudio.example.screens.main

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel<MainViewModel> { DefaultMainViewModel(get()) }
}