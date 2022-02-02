package com.example.one2onerelationroomdb.db_relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.one2onerelationroomdb.entities.Director
import com.example.one2onerelationroomdb.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)