package com.karsoft.gymapp.data.product

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class ProductData(
    @PrimaryKey(autoGenerate = true) val id: Int  = 0,
    val name: String
)
