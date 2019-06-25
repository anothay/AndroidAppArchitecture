package com.wolvesstudio.example.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wolvesstudio.example.core.Model
import com.wolvesstudio.example.core.ModelLocalRepository



abstract class DetailViewModel: ViewModel() {
    abstract val model: MutableLiveData<Model>
    abstract fun set(id: String)
}

class DefaultDetailViewModel(private var modelLocalRepository: ModelLocalRepository): DetailViewModel() {
    override val model: MutableLiveData<Model> = MutableLiveData();

    override fun set(id: String) {
        model.postValue(modelLocalRepository.getById(id)!!)
    }
}