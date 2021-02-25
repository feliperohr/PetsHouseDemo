package com.example.petshouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.petshouse.adapter.TaskAdapter;

public class TaskListActivity extends AppCompatActivity {

    RecyclerView rv;
    String names[], dates[], descs[];
    int images[] = {R.drawable.i1, R.drawable.i3,
            R.drawable.i2, R.drawable.i5,
            R.drawable.i4, R.drawable.i3};

    private Toolbar menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        menu = findViewById(R.id.menu);
        menu.setTitle("Nome_do_usuario");
        setSupportActionBar(menu);

        names = getResources().getStringArray(R.array.name);
        dates = getResources().getStringArray(R.array.date);
        descs = getResources().getStringArray(R.array.desc);

        rv = findViewById(R.id.rv_feed);

        TaskAdapter taskAdapter = new TaskAdapter(this, names, dates, descs, images);
        rv.setAdapter(taskAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                Intent intent1 = new Intent(this, ProfileActivity.class);
                startActivity(intent1);
            case R.id.notification:
                Intent intent2 = new Intent(this, NotificationActivity.class);
                startActivity(intent2);
                return true;
            case R.id.task:
                Intent intent3 = new Intent(this, TaskListActivity.class);
                startActivity(intent3);
                return true;
            case R.id.logout:
                Intent intent4 = new Intent(this, LoginActivity.class);
                startActivity(intent4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}