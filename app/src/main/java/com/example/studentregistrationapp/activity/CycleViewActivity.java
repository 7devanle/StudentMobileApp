package com.example.studentregistrationapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.studentregistrationapp.adapter.AdminAdapter;
import com.example.studentregistrationapp.R;
import com.example.studentregistrationapp.data.model.Student;
import com.example.studentregistrationapp.data.viewModel.AdminViewModel;
import com.example.studentregistrationapp.databinding.ActivityRecyclerStudentsBinding;

import java.util.List;

public class CycleViewActivity extends AppCompatActivity {

    private AdminViewModel adminViewModel;
    ActivityRecyclerStudentsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = binding.recyclerView;

        List<Student> students = adminViewModel.getAllStudents().getValue();
        students.add(new Student("Ridwan Abdulfatah", "Lagos", R.drawable.img, "Computer Science", "Science"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdminAdapter(getApplicationContext(), (AdminViewModel) students));

    }
}