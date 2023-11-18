package com.example.studentregistrationapp.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.studentregistrationapp.data.model.Student;

import java.util.List;

@Dao
public interface StudentRepo {
    @Insert
    void insert(Student student);

    @Update
    void update(Student student);
    @Delete
    void delete(Student student);

    @Query("DELETE FROM students")
    void deleteAllStudents();

    @Query("SELECT * FROM students ORDER BY mat DESC")
    LiveData<List<Student>> getAllStudents();

    @Query("SELECT * FROM students WHERE blackListed = 1 ORDER BY mat DESC")
    LiveData<List<Student>> getBlacklisted();

    @Query("SELECT * FROM students WHERE blackListed = 0 ORDER BY mat DESC")
    LiveData<List<Student>> getNonBlacklisted();

    @Query("SELECT * FROM students WHERE mat = :student_mat LIMIT 1")
    LiveData<Student> getStudent(String student_mat);

    @Query("SELECT * FROM students WHERE mat like '%' || :query || '%' ")
    LiveData<Student> searchStudent(String query);

    @Query("SELECT * FROM students WHERE student_id = :id LIMIT 1")
    LiveData<Student> getStudent(Long id);


}
