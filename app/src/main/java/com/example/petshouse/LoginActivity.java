package com.example.petshouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.petshouse.model.dto.CustomerDTO;
import com.example.petshouse.retrofit.PetOwnerService;
import com.example.petshouse.retrofit.RetrofitConfig;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout username;
    TextInputLayout password;

    Button forget;
    Button signIn;
    Button signUp;

    CheckBox petOwnerCB;
    CheckBox petSitterCB;


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

        petOwnerCB = findViewById(R.id.cb_petOwner);
        petSitterCB = findViewById(R.id.cb_petSitter);

        signIn.setOnClickListener(v -> {

                if(username.getEditText().getText().toString() != ""
                    && password.getEditText().getText().toString() != ""){

                    CustomerDTO petOwner = new CustomerDTO();
                    petOwner.setLogin(username.getEditText().getText().toString());
                    petOwner.setPassword(password.getEditText().getText().toString());
                    petOwner.setId(null);

                    if(petOwnerCB.isChecked()){

                        Call<CustomerDTO> call = new RetrofitConfig().getPetOwnerService().login(petOwner);

                        Log.e("Oject: ", petOwner.toString());
                        Log.wtf("URL Called", call.request().url() + "");

                        call.enqueue(new Callback<CustomerDTO>() {
                            @Override
                            public void onResponse(Call<CustomerDTO> call, Response<CustomerDTO> response) {
                                if(response.isSuccessful()){

                                    Log.e("Api response: ", response.toString());
                                    Log.e("Api response: ", response.body().toString());

//                                    SharedPreferences sharedObject =

                                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                                    startActivity(intent);

                                }
                                else{
                                    Toast.makeText(LoginActivity.this, "Dados de usuário ou senha inválidos!", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<CustomerDTO> call, Throwable t) {
                                Log.e("Login:   ", t.getMessage());
                            }
                        });

                    }else if(petSitterCB.isChecked()){

                        Toast.makeText(LoginActivity.this, username.getEditText().getText().toString() + " - "  + password.getEditText().getText().toString(),
                                Toast.LENGTH_LONG).show();

                        Call<CustomerDTO> call = new RetrofitConfig().getPetSitterService().login(petOwner);

                        call.enqueue(new Callback<CustomerDTO>() {
                            @Override
                            public void onResponse(Call<CustomerDTO> call, Response<CustomerDTO> response) {

                                Intent intent = new Intent(LoginActivity.this, TaskListActivity.class);
                                startActivity(intent);

                            }

                            @Override
                            public void onFailure(Call<CustomerDTO> call, Throwable t) {

                            }
                        });

                    }else{
                        Toast.makeText(LoginActivity.this, "Por favor, selecione um tipo de perfil!",
                                Toast.LENGTH_LONG).show();
                    }

                }
        });

        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpActivity2.class);
            startActivity(intent);

        });

        forget.setOnClickListener(v -> {

        });

    }

    public void checkAndUncheckCb1(View v){
        if(petSitterCB.isChecked()){
            petSitterCB.setClickable(false);
            petSitterCB.setChecked(!petSitterCB.isChecked());
        }
        petOwnerCB.setChecked(!petOwnerCB.isChecked());
    }

    public void checkAndUncheckCb2(View v){
        if(petOwnerCB.isChecked()){
            petOwnerCB.setClickable(false);
            petOwnerCB.setChecked(!petOwnerCB.isChecked());
        }
        petSitterCB.setChecked(!petSitterCB.isChecked());
    }

}