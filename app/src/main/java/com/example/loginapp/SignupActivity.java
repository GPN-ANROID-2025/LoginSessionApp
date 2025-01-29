package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginapp.databinding.ActivitySignupBinding;

import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    MyPrefs myPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myPrefs=new MyPrefs(SignupActivity.this);

        if(myPrefs.getIsLoggedIn())
        {
            Intent intent=new Intent(SignupActivity.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(validateFields())
                {
                    Log.d("mytag","Valid");
                    myPrefs.setName(binding.etName.getText().toString());
                    myPrefs.setMobile(binding.etMobile.getText().toString());
                    myPrefs.setPassword(binding.etPassword.getText().toString());
                    Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);

                }

            }
        });
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean validateFields(){

        ArrayList<Boolean> list=new ArrayList<>();

        if(MyValidator.isValidName(binding.etName.getText().toString()))
        {
            binding.layoutName.setError(null);
            list.add(true);
        }else{
            binding.layoutName.setError("Name is required");
            list.add(false);

        }
        if(MyValidator.isValidMobile(binding.etMobile.getText().toString()))
        {
            binding.layoutMobile.setError(null);
            list.add(true);
        }else{
            binding.layoutMobile.setError("Mobile is required");
            list.add(false);

        }

        return !list.contains(false);
    }
}