package com.example.one2onerelationroomdb.dao

import androidx.room.*
import com.example.one2onerelationroomdb.db_relations.SchoolAndDirector
import com.example.one2onerelationroomdb.entities.Director
import com.example.one2onerelationroomdb.entities.School

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(schoolDao: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirector(schoolName: String): List<SchoolAndDirector>
}