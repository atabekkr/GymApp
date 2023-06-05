package com.karsoft.gymapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.karsoft.gymapp.data.product.ProductDao
import com.karsoft.gymapp.data.product.ProductData

@Database(entities = [ProductData::class], version = 1)
abstract class GymDatabase : RoomDatabase() {

    companion object {
        private var instance: GymDatabase? = null

        fun getInstance(context: Context) : GymDatabase {
            instance?.let {
                return it
            }
            val db = Room.databaseBuilder(context, GymDatabase::class.java, "gym.db")
                .allowMainThreadQueries()
                .build()

            instance = db
            return db
        }
    }

    abstract fun getProductDao() : ProductDao

}