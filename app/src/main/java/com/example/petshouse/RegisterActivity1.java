package com.example.petshouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;


public class RegisterActivity1 extends AppCompatActivity {

    private CheckBox cbPetOwner;
    private CheckBox cbPetSitter;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        cbPetOwner = findViewById(R.id.cb_petOwner);
        cbPetSitter = findViewById(R.id.cb_petSitter);

        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity2.class);
            startActivity(intent);
//            setContentView(R.layout.activity_register2);
        });

    }



}