package com.pm.teamtrainig.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pm.teamtrainig.data.entities.Training

@Dao
interface TrainingDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addProduct(product: Training)

    @Update
    fun updateProduct(product: Training)

    @Query("SELECT * FROM product ORDER BY id DESC")
    fun readAllProducts(): LiveData<List<Training>>

    @Delete
    fun deleteProduct(product:Training)
}