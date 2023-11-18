package com.example.studentregistrationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.studentregistrationapp.databinding.ActivityLoginPageBinding;
import com.example.studentregistrationapp.data.viewModel.AdminViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityLoginPageBinding binding;
    AdminViewModel avm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        avm = new ViewModelProvider(this).get(AdminViewModel.class);

        binding.loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username = binding.username.getText().toString();
                        String password = binding.passwordtext.getText().toString();

                    }
                }
        );
    }
}