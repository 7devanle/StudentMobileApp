package com.example.studentregistrationapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentregistrationapp.databinding.ActivityViewAllStudentsBinding;


public class AdminViewHolder extends RecyclerView.ViewHolder {
    ActivityViewAllStudentsBinding binding;
    ImageView imageView;
    TextView nameView, locationView, departmentView, facultyView;
    public AdminViewHolder(@NonNull View studentView) {
        super(studentView);
        imageView = binding.image;
        nameView = binding.name;
        locationView = binding.location;
        departmentView = binding.department;
        facultyView = binding.faculty;
    }
}
