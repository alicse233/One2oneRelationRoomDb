package com.example.one2onerelationroomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.one2onerelationroomdb.dao.SchoolDao
import com.example.one2onerelationroomdb.entities.Director
import com.example.one2onerelationroomdb.entities.School

@Database(
    entities = [
        School::class,
        Director::class
    ],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}