package com.karsoft.gymapp.data.product

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM food")
    suspend fun getAllProducts() : List<ProductData>

    @Insert
    suspend fun addProduct(productData: ProductData)

    @Delete
    suspend fun deleteProduct(productData: ProductData)

}