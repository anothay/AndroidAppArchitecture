package com.techprostudio.example.core.persistence
import io.reactivex.Observable
import  io.reactivex.rxkotlin.toObservable

interface LocalRepository<Model: Identifiable> {
    fun getById(id: String): Model?
    fun getList(): List<Model>
    fun save(value: Model)
    fun observeList(): Observable<List<Model>>
}