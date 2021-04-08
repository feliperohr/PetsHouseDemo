package com.example.petshouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petshouse.model.dto.CustomerDTO;
import com.example.petshouse.model.dto.TaskDTO;
import com.example.petshouse.retrofit.RetrofitConfig;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.time.LocalDate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskActivity extends AppCompatActivity {

    private Button mDatePickerBtn;
    private Button newTaskBtn;
    private ImageView img;

    private TextInputLayout txtItems;
    private AutoCompleteTextView autoCompleteTextView;

    private TextView date;
    private CustomerDTO customer;

    private EditText bigText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        customer = getCustomerData();


        img = findViewById(R.id.imageView4);
        img.setImageResource(R.drawable.i3);

        date = findViewById(R.id.selectedDate);

        txtItems = findViewById(R.id.txt_task_filter);
        autoCompleteTextView = findViewById(R.id.autoCompleteFilter);
        newTaskBtn = findViewById(R.id.btn_new_task);
        bigText = findViewById(R.id.big_field);

        String filters[] = getResources().getStringArray(R.array.filters);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_item, filters);
        autoCompleteTextView.setAdapter(arrayAdapter);


        //calendar
        mDatePickerBtn = findViewById(R.id.date_picker_btn);

        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Selecione uma data:");
        MaterialDatePicker materialDatePicker = builder.build();
        mDatePickerBtn.setOnClickListener(v -> {
            materialDatePicker.show(getSupportFragmentManager(), "DATA_PICKER");
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {

                date.setText(materialDatePicker.getHeaderText());
            }
        });


        newTaskBtn.setOnClickListener(v -> {

            AutoCompleteTextView simpleAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteFilter);
            String value = simpleAutoCompleteTextView.getText().toString();

            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setAnimalType(convertTheAutoCompleteValue(value));
            taskDTO.setCustomer(customer);
//            taskDTO.setStart_date();
//            taskDTO.setEnd_date();
            taskDTO.setScheduled(false);


            Call<Void> call = new RetrofitConfig().getTaskService().register(taskDTO);

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Toast.makeText(TaskActivity.this,
                            "Serviço cadastrado!",
                            Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(TaskActivity.this, ProfileActivity.class);
                    startActivity(intent);

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });


        });

    }

//    private LocalDate convertDateInterval(TextView date) {
//        String[] dateA = date.getText().toString().split("-");
//
//    }

    private void resetfields(){
        date.setText("");
        bigText.setText("");
    }

    private CustomerDTO getCustomerData(){
        SharedPreferences sharedPreferences = getSharedPreferences("customerData", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("CustomerDTO", "");
        CustomerDTO customer = gson.fromJson(json, CustomerDTO.class);
        return customer;
    }

    private String convertTheAutoCompleteValue(String value) {
        if(value.equals("Cães e Gatos")){
            return "BOTH";
        }else if(value.equals("Apenas gatos")){
            return "CAT";
        }
        return "DOG";

    }


}