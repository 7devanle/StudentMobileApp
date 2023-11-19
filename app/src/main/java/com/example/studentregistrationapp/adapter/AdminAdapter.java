package com.example.studentregistrationapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentregistrationapp.R;
import com.example.studentregistrationapp.data.model.Student;
import com.example.studentregistrationapp.data.viewModel.AdminViewModel;
import com.example.studentregistrationapp.databinding.ActivityViewAllStudentsBinding;

import java.util.List;

public class AdminAdapter extends RecyclerView.Adapter<AdminViewHolder> {

    Context context;
    List<Student> students;
    ActivityViewAllStudentsBinding binding;

    public AdminAdapter(Context context, AdminViewModel adminViewModel) {
        this.context = context;
        this.students = adminViewModel.getAllStudents().getValue();
    }

    @NonNull
    @Override
    public AdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdminViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_view_all_students, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull AdminViewHolder holder, int position) {
        holder.nameView.setText(students.get(position).getName());
        holder.locationView.setText(students.get(position).getLocation());
        holder.departmentView.setText(students.get(position).getDepartment());
        holder.facultyView.setText(students.get(position).getFaculty());
        holder.imageView.setImageResource(R.drawable.img);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
