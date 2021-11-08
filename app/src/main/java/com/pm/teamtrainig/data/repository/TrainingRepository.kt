package com.pm.teamtrainig.data.repository

import androidx.lifecycle.LiveData
import com.pm.teamtrainig.data.dao.TrainingDao
import com.pm.teamtrainig.data.entities.Training

class TrainingRepository(private  val trainingDao: TrainingDao) {
    val readAllProducts : LiveData<List<Training>> = trainingDao.readAllProducts()

    suspend fun addProduct(product: Training){
        trainingDao.addProduct(product)
    }

    suspend fun updateProduct(product: Training) {
        trainingDao.updateProduct(product)
    }

    suspend fun deleteProduct(product: Training) {
        trainingDao.deleteProduct(product)
    }
}