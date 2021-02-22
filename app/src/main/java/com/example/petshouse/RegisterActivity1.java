package com.example.petshouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;


import com.google.android.material.card.MaterialCardView;

public class RegisterActivity1 extends AppCompatActivity {

    private CheckBox cbPetOwner;
    private CheckBox cbPetSitter;
    private MaterialCardView cv1;
    private MaterialCardView cv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        cbPetOwner = findViewById(R.id.cb_petOwner);
        cbPetSitter = findViewById(R.id.cb_petSitter);


        cbPetOwner.setChecked(true);

//        cv1 = findViewById(R.id.cardView1);
//        cv2 = findViewById(R.id.cardView2);



    }

}