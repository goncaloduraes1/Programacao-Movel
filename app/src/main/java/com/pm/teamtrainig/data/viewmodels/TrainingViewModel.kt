package com.pm.teamtrainig.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.pm.teamtrainig.data.dao.TrainingDao
import com.pm.teamtrainig.data.database.TrainingDatabase
import com.pm.teamtrainig.data.entities.Training
import com.pm.teamtrainig.data.repository.TrainingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrainingViewModel(application: Application) : AndroidViewModel (application){
    private val readAllProducts: LiveData<List<Training>>
    private val repository: TrainingRepository

    init {
        val trainingDao = TrainingDatabase.getDatabase(application).trainingDao()
        repository = TrainingRepository(trainingDao)
        readAllProducts = repository.readAllProducts
    }

    fun  addProduct(product: Training){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProduct(product)
        }
    }

    fun updateProduct(product: Training) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProduct(product)
        }
    }

    fun  deleteProduct(product: Training) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteProduct(product)
        }
    }
}