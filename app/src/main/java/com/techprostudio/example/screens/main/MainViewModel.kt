package com.techprostudio.example.screens.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techprostudio.example.core.Model
import com.techprostudio.example.core.ModelLocalRepository
import io.reactivex.disposables.Disposable
import java.util.*


abstract class MainViewModel: ViewModel() {
    abstract val list: LiveData<List<Model>>
    abstract fun refresh()
}

class DefaultMainViewModel(private  var modelLocalRepository: ModelLocalRepository): MainViewModel() {

    override val list: MutableLiveData<List<Model>> = MutableLiveData()

    private  var disposable: Disposable?=null

    init {
        list.postValue(modelLocalRepository.getList())
        observeList()
    }


    private fun observeList() {
        disposable = modelLocalRepository.observeList().subscribe { new ->
            list.postValue(new)
        }
    }

    override fun refresh() {
        val new = Model(UUID.randomUUID().toString(), Date().time.toString())
        modelLocalRepository.save(new)

    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}