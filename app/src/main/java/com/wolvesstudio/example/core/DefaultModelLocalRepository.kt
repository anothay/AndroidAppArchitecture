package com.wolvesstudio.example.core

import com.wolvesstudio.example.core.persistence.InmemoryLocalRepository


class DefaultModelLocalRepository: InmemoryLocalRepository<Model>(), ModelLocalRepository {

}