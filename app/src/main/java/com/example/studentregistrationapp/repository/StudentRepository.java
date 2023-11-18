package com.example.studentregistrationapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studentregistrationapp.data.dao.CourseRepo;
import com.example.studentregistrationapp.data.dao.StudentRepo;
import com.example.studentregistrationapp.data.database.AdminDatabase;
import com.example.studentregistrationapp.data.database.StudentDatabase;
import com.example.studentregistrationapp.data.model.Course;
import com.example.studentregistrationapp.data.model.Student;

import java.util.List;

public class StudentRepository {
    private StudentRepo studentRepo;
    private CourseRepo courseRepo;
    public StudentRepository(Application application){
        StudentDatabase studentDatabase = StudentDatabase.getInstance(application);
        studentRepo = studentDatabase.studentRepo();
        courseRepo = studentDatabase.courseRepo();
    }

    void insert(Course course) {
        StudentDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> courseRepo.insert(course));

    }

    void update(Course course) {
        StudentDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> courseRepo.update(course));
    }

    void delete(Course course) {
        StudentDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> courseRepo.delete(course));
    }

    void deleteAllCourses() {
        StudentDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> courseRepo.deleteAllCourses());
    }

    LiveData<List<Course>> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    Course getCourse(String course_name) {
        return courseRepo.getCourse(course_name);
    }

}
