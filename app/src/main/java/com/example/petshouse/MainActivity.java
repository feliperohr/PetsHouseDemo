package com.example.petshouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private Button changeFrame;
    private Toolbar menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFrame = findViewById(R.id.btn_login);
        menu = findViewById(R.id.menu);
        menu.setTitle("Home");
        setSupportActionBar(menu);

        changeFrame.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.profile:
                Intent intent1 = new Intent(this, ProfileActivity.class);
                startActivity(intent1);
                return true;
//            case R.id.notification:
//                Intent intent2 = new Intent(this, NotificationActivity.class);
//                startActivity(intent2);
//                return true;
//            case R.id.task:
//                Intent intent3 = new Intent(this, TaskActivity.class);
//                startActivity(intent3);
//                return true;
            case R.id.logout:
                Intent intent4 = new Intent(this, LoginActivity.class);
                startActivity(intent4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}