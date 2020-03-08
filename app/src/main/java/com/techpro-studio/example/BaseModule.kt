package com.wolvesstudio.example

import com.wolvesstudio.example.core.DefaultModelLocalRepository
import com.wolvesstudio.example.core.ModelLocalRepository
import org.koin.dsl.module


val baseModule = module {
    single<ModelLocalRepository> { DefaultModelLocalRepository() }
}