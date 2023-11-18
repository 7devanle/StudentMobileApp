package com.example.studentregistrationapp.data.database;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.studentregistrationapp.data.dao.CourseRepo;
import com.example.studentregistrationapp.data.model.Course;
import com.example.studentregistrationapp.data.model.Student;
import com.example.studentregistrationapp.data.dao.StudentRepo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class, Course.class}, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    public abstract StudentRepo studentRepo();
    public abstract CourseRepo courseRepo();
    private static volatile StudentDatabase INSTANCE;
    private static final int NO_OF_THREADS = 4;
    public static final ExecutorService DATABASE_WRITE_EXECUTOR = Executors.newFixedThreadPool(NO_OF_THREADS);

    //creating a singleton
    public static StudentDatabase getInstance(final Context CONTEXT){
        if (INSTANCE==null){
            synchronized (StudentDatabase.class){
                if (INSTANCE==null){
                    INSTANCE=Room.databaseBuilder(CONTEXT.getApplicationContext(),
                                    StudentDatabase.class, "student_database")
                            .addCallback(sRoomDatabaseCallBack).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            DATABASE_WRITE_EXECUTOR.execute(()->{

            });
        }
    };
}
