package com.example.studentregistrationapp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity(tableName = "courses")
public class Course {
    @NotNull
    @ColumnInfo(name = "name")
    private String name;
    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "course_id")
    private int code;
    private int noOfRegisteredStudent;
    private String lecturer;

    public Course(String name, int noOfRegisteredStudent, String lecturer) {
        this.name = name;
        this.noOfRegisteredStudent = noOfRegisteredStudent;
        this.lecturer = lecturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getNoOfRegisteredStudent() {
        return noOfRegisteredStudent;
    }

    public void setNoOfRegisteredStudent(int noOfRegisteredStudent) {
        this.noOfRegisteredStudent = noOfRegisteredStudent;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
}
