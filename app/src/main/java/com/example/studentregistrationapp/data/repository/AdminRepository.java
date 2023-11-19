package com.example.studentregistrationapp.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.studentregistrationapp.data.dao.AdminRepo;
import com.example.studentregistrationapp.data.dao.StudentRepo;
import com.example.studentregistrationapp.data.database.AdminDatabase;
import com.example.studentregistrationapp.data.model.Admin;
import com.example.studentregistrationapp.data.model.Student;

import java.util.List;

public class AdminRepository {
    AdminRepo adminRepo;
    StudentRepo studentRepo;

    public AdminRepository(Application application){
        AdminDatabase adminDatabase = AdminDatabase.getInstance(application);
        studentRepo= adminDatabase.studentRepo();
        adminRepo=adminDatabase.adminRepo();

    }

    public void insertAdmin(Admin admin){
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> adminRepo.insert(admin));
    }

    public String login(Admin admin){
        Admin availableAdmin = adminRepo.getAdmin(admin.getUsername()).getValue();
        if(availableAdmin!= null && admin.getPassword() == availableAdmin.getPassword()){
            return "logged";
        }
        return "incorrect";
    }

    public void update(Admin admin) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> adminRepo.update(admin));
    }

    public void delete(Admin admin) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> adminRepo.delete(admin));
    }

    public LiveData<Admin> getAdmin(String admin_name) {
        return adminRepo.getAdmin(admin_name);
    }

    public LiveData<Admin> getAdmin(int adminId) {
        return adminRepo.getAdmin(adminId);
    }

    public void insert(Student student) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> studentRepo.insert(student));
    }

    public void update(Student student) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> studentRepo.update(student));
    }

    public void delete(Student student) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> studentRepo.delete(student));
    }

    public void deleteAllStudents() {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(()-> studentRepo.deleteAllStudents());
    }

    public LiveData<List<Student>> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    public LiveData<List<Student>> getBlacklisted(){
        return studentRepo.getBlacklisted();
    }

    public LiveData<List<Student>> getNonBlacklisted(){
        return studentRepo.getNonBlacklisted();
    }

    public LiveData<Student> getStudent(String student_mat) {
        return studentRepo.getStudent(student_mat);
    }

    public LiveData<Student> searchStudent(String query) {
        return studentRepo.searchStudent(query);
    }

    public LiveData<Student> getStudent(int id) {
        return studentRepo.getStudent(id);
    }

}
