package com.example.studentregistrationapp.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.studentregistrationapp.data.model.Course;
import com.example.studentregistrationapp.data.dao.CourseRepo;

@Database(entities = {Course.class}, version = 1, exportSchema = false)
public abstract class CourseDatabase extends RoomDatabase {
    private static CourseDatabase instance;
    public abstract CourseRepo courseRepo();

    public static synchronized CourseDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            CourseDatabase.class, "course_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
