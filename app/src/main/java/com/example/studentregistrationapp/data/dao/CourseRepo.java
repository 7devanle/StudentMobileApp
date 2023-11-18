package com.example.studentregistrationapp.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studentregistrationapp.data.model.Course;

import java.util.List;

@Dao
public interface CourseRepo {
    @Insert
    void insert(Course course);

    @Update
    void update(Course course);
    @Delete
    void delete(Course course);

    @Query("DELETE FROM courses")
    void deleteAllCourses();

    @Query("SELECT * FROM courses ORDER BY name DESC")
    LiveData<List<Course>> getAllCourses();

    @Query("SELECT * FROM courses WHERE name = :course_name LIMIT 1")
    Course getCourse(String course_name);
}
