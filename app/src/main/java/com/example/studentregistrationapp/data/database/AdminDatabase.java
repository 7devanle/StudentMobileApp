package com.example.studentregistrationapp.data.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.studentregistrationapp.data.dao.StudentRepo;
import com.example.studentregistrationapp.data.model.Admin;
import com.example.studentregistrationapp.data.dao.AdminRepo;
import com.example.studentregistrationapp.data.model.Student;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Admin.class, Student.class}, version = 1, exportSchema = false)
public abstract class AdminDatabase extends RoomDatabase {
    public abstract AdminRepo adminRepo();
    public abstract StudentRepo studentRepo();
    private static volatile AdminDatabase INSTANCE;
    private static final int NO_OF_THREADS = 4;
    public static final ExecutorService DATABASE_WRITE_EXECUTOR = Executors.newFixedThreadPool(NO_OF_THREADS);

    public static AdminDatabase getInstance(final Context CONTEXT){
        if (INSTANCE==null){
            synchronized (AdminDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(CONTEXT.getApplicationContext()
                                    ,AdminDatabase.class, "admin_database")
                            .addCallback(aRoomDatabaseCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;

    }

    private static RoomDatabase.Callback aRoomDatabaseCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            DATABASE_WRITE_EXECUTOR.execute(()->{

                AdminRepo adminRepo = INSTANCE.adminRepo();

                adminRepo.deleteAllAdmins();

                Admin admin1 = new Admin("Adeniran", "ade1234");
                Admin admin2 = new Admin("Bashorun Ga", "bashorun1234");
                Admin admin3 = new Admin("Rehoboth", "hack123");

                adminRepo.insert(admin1);
                adminRepo.insert(admin2);
                adminRepo.insert(admin3);
            });
        }
    };

}
