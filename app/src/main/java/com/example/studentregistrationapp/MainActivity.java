package com.example.studentregistrationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.studentregistrationapp.activity.RegisterStudentActivity;
import com.example.studentregistrationapp.activity.ViewAllStudents;
import com.example.studentregistrationapp.data.viewModel.AdminViewModel;
import com.example.studentregistrationapp.databinding.ActivityHomePageBinding;
import com.example.studentregistrationapp.databinding.ActivityRegisterStudentBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityHomePageBinding homePageBinding;
    AdminViewModel avm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homePageBinding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(homePageBinding.getRoot());

        avm = new ViewModelProvider(this).get(AdminViewModel.class);

        homePageBinding.registerStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), RegisterStudentActivity.class);
                startActivity(intent);
            }
        });

        homePageBinding.viewStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ViewAllStudents.class);
                startActivity(intent);
            }
        });

        homePageBinding.blacklisted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        homePageBinding.nonBlacklisted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}