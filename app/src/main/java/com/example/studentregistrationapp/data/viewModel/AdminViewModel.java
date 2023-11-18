package com.example.studentregistrationapp.data.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.studentregistrationapp.data.model.Admin;
import com.example.studentregistrationapp.data.model.Student;
import com.example.studentregistrationapp.data.repository.AdminRepository;

import java.util.List;

public class AdminViewModel extends AndroidViewModel {
    AdminRepository adminRepository;
    public AdminViewModel(@NonNull Application application) {
        super(application);
        adminRepository = new AdminRepository(application);
    }

    public String login(Admin admin){
        return adminRepository.login(admin);
    }

    public void update(Admin admin) {
        adminRepository.update(admin);
    }

    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }

    public LiveData<Admin> getAdmin(String admin_name) {
        return adminRepository.getAdmin(admin_name);
    }

    public LiveData<Admin> getAdmin(Long adminId) {
        return adminRepository.getAdmin(adminId);
    }

    public void insert(Student student) {
        adminRepository.insert(student);
    }

    public void update(Student student) {
        adminRepository.update(student);
    }

    public void delete(Student student) {
        adminRepository.delete(student);
    }

    public void deleteAllStudents() {
        adminRepository.deleteAllStudents();
    }

    public LiveData<List<Student>> getAllStudents() {
        return adminRepository.getAllStudents();
    }

    LiveData<List<Student>> getBlacklisted(){
        return adminRepository.getBlacklisted();
    }

    LiveData<List<Student>> getNonBlacklisted(){
        return adminRepository.getNonBlacklisted();
    }

    public LiveData<Student> getStudent(String student_mat) {
        return adminRepository.getStudent(student_mat);
    }

    public LiveData<Student> searchStudent(String query) {
        return adminRepository.searchStudent(query);
    }

    public LiveData<Student> getStudent(Long id) {
        return adminRepository.getStudent(id);
    }

}
