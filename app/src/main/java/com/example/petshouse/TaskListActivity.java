package com.example.petshouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.petshouse.adapter.TaskAdapter;
import com.example.petshouse.model.dto.CustomerDTO;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

public class TaskListActivity extends AppCompatActivity {

    RecyclerView rv;
    String names[], dates[], descs[];
    int images[] = {R.drawable.i1, R.drawable.i3,
            R.drawable.i2, R.drawable.i5,
            R.drawable.i4, R.drawable.i3};

    private Toolbar menu;
    private TextInputLayout txtItems;
    private AutoCompleteTextView autoCompleteTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        CustomerDTO customer = getCustomerData();

        menu = findViewById(R.id.menu);
//        menu.setTitle(customer.getProfile().getName());

        setSupportActionBar(menu);



        names = getResources().getStringArray(R.array.name);
        dates = getResources().getStringArray(R.array.date);
        descs = getResources().getStringArray(R.array.desc);

        rv = findViewById(R.id.rv_feed);

        TaskAdapter taskAdapter = new TaskAdapter(this, names, dates, descs, images);
        rv.setAdapter(taskAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        txtItems = findViewById(R.id.txt_task_filter1);
        autoCompleteTextView = findViewById(R.id.autoCompleteFilter1);



        String filters[] = getResources().getStringArray(R.array.filters);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_item, filters);
        autoCompleteTextView.setAdapter(arrayAdapter);


    }

    private CustomerDTO getCustomerData(){
        SharedPreferences sharedPreferences = getSharedPreferences("customerData", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("CustomerDTO", "");
        CustomerDTO customer = gson.fromJson(json, CustomerDTO.class);
        return customer;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_bar_pet_sitter, menu);
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