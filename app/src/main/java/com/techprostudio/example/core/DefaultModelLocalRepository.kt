package com.techprostudio.example.core

import com.techprostudio.example.core.persistence.InmemoryLocalRepository


class DefaultModelLocalRepository: InmemoryLocalRepository<Model>(), ModelLocalRepository {

}