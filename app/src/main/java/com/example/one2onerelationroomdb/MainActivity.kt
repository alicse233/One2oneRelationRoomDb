package com.example.one2onerelationroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.one2onerelationroomdb.dao.SchoolDao
import com.example.one2onerelationroomdb.entities.Director
import com.example.one2onerelationroomdb.entities.School
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao: SchoolDao = AppDataBase.getInstance(this).schoolDao

        val schools = listOf(
            School("kotlin school"),
            School("Java school"),
            School("xml school")
        )

        val directors = listOf(
            Director("Directot kotlin school", "Phillip"),
            Director("Java school", "Max"),
            Director("xml school", "Inna")
        )

        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            dao.insertDirector(Director("xml school", "Inna"))
            schools.forEach { dao.insertSchool(it) }
            dao.insertSchool(School("xml school"))
        }
    }
}