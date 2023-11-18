package com.example.studentregistrationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.studentregistrationapp.databinding.ActivityMainBinding;
import com.example.studentregistrationapp.viewModel.AdminViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    AdminViewModel adminViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        adminViewModel = new ViewModelProvider(this).get(AdminViewModel.class);


        binding.fab
    }
}