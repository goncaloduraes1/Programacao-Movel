package com.pm.teamtrainig.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pm.teamtrainig.data.dao.TrainingDao
import com.pm.teamtrainig.data.entities.Training

@Database(entities = [Training :: class], version = 1, exportSchema = false)
abstract class TrainingDatabase : RoomDatabase() {

    abstract fun trainingDao() : TrainingDao
    companion object {
        @Volatile
        private var INSTANCE: TrainingDatabase? = null

        fun getDatabase(context: Context): TrainingDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TrainingDatabase::class.java,
                    "company_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}