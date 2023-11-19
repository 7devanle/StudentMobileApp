package com.example.studentregistrationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.studentregistrationapp.data.model.Admin;
import com.example.studentregistrationapp.data.viewModel.AdminViewModel;
import com.example.studentregistrationapp.databinding.ActivityLoginPageBinding;

public class LoginPage extends AppCompatActivity {

    AdminViewModel adminViewModel;
    private ActivityLoginPageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        adminViewModel = new ViewModelProvider(this).get(AdminViewModel.class);
        binding.loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                String username = binding.username.getText().toString().trim();
                String password = binding.passwordtext.getText().toString().trim();
                Admin admin = new Admin(username, password);
                if(adminViewModel.login(admin) == "logged"){
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginPage.this, "Kindly check admin details again", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}