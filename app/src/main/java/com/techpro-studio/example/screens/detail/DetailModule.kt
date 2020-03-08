package com.wolvesstudio.example.screens.detail

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailModule = module {
    viewModel<DetailViewModel> { DefaultDetailViewModel(get()) }
}