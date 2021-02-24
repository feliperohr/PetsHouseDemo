package com.example.petshouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.petshouse.model.UserModel;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout username;
    TextInputLayout password;
    UserModel userModel;

    Button forget;
    Button signIn;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setActionBar(null);

        username = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);

        signIn = findViewById(R.id.btn_sign_in);
        signUp = findViewById(R.id.btn_sign_up);
        forget = findViewById(R.id.btn_forget);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                username.getEditText().setText("");
//                password.getEditText().setText("");

//                userModel = new UserModel(1);

                if(userModel.getUserType() == 1){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpActivity1.class);
            startActivity(intent);

        });

        forget.setOnClickListener(v -> {

        });
    }
}