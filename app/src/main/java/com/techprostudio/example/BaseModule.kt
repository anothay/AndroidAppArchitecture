package com.techprostudio.example

import com.techprostudio.example.core.DefaultModelLocalRepository
import com.techprostudio.example.core.ModelLocalRepository
import org.koin.dsl.module


val baseModule = module {
    single<ModelLocalRepository> { DefaultModelLocalRepository() }
}