package com.example.petshouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        this.updateView();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        this.updateView();

    }

    public void updateView(){
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
    }

    public void previousLayout(View view) {
        Intent intent = new Intent(this, SignUpActivity1.class);
        startActivity(intent);
    }
}