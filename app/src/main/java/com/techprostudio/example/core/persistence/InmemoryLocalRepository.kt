package com.techprostudio.example.core.persistence

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

open class InmemoryLocalRepository<Model: Identifiable>: LocalRepository<Model> {

    override fun observeList(): Observable<List<Model>> = notifier

    private var valueMap: MutableMap<String, Model> = mutableMapOf()
    private var notifier: PublishSubject<List<Model>> = PublishSubject.create()

    override fun getById(id: String): Model? {
        return valueMap[id]
    }

    override fun getList(): List<Model> {
        return valueMap.values.toList()
    }

    override fun save(value: Model) {
        valueMap[value.id] = value
        notifier.onNext(getList())
    }

}