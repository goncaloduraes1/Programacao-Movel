package com.pm.teamtrainig.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Training")
class Training {
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
}