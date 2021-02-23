package com.example.petshouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class SignUpOneActivity extends AppCompatActivity {

    private CheckBox petOwner;
    private CheckBox petSitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_one);

        petOwner = findViewById(R.id.cb_petOwner);
        petSitter = findViewById(R.id.cb_petSitter);


    }

    public void setCustomerType(View view){

        Intent intent = new Intent(this, ProfileActivity.class);

        if(petOwner.isChecked()){
            //UserModel.setUserType(1)
            //intent.putExtra(EXTRA_MESSAGE, message);
        }else if(petSitter.isChecked()){
            //UserModel.setUserType(2)
            //intent.putExtra(EXTRA_MESSAGE, message);
        }


        startActivity(intent);
    }

    public void checkAndUncheckCb1(View v){
        if(petSitter.isChecked()){
            petSitter.setChecked(!petSitter.isChecked());
        }
        petOwner.setChecked(!petOwner.isChecked());
    }

    public void checkAndUncheckCb2(View v){
        if(petOwner.isChecked()){
            petOwner.setChecked(!petOwner.isChecked());
        }
        petSitter.setChecked(!petSitter.isChecked());
    }
}