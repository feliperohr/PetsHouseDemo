package com.example.petshouse;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.example.petshouse.model.dto.CustomerDTO;
import com.example.petshouse.model.dto.ProfileDTO;
import com.example.petshouse.retrofit.RetrofitConfig;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity2 extends AppCompatActivity {

    private TextInputLayout name;
    private TextInputLayout cpf;
    private TextInputLayout phone;
    private TextInputLayout username;
    private TextInputLayout password1;
    private TextInputLayout password2;

    private SwitchMaterial sw_cat;
    private SwitchMaterial sw_dog;
    private String USER_TYPE;

    private Button btn_regis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        USER_TYPE = getIntent().getStringExtra("user_type");

        name = findViewById(R.id.txt_name);
        cpf = findViewById(R.id.txt_cpf);
        phone = findViewById(R.id.txt_phone);
        username = findViewById(R.id.txt_user_name);

        password1 = findViewById(R.id.txt_password1);
        password2 = findViewById(R.id.txt_password2);
        sw_cat = findViewById(R.id.sw_cat);
        sw_dog = findViewById(R.id.sw_dog);

        btn_regis = findViewById(R.id.btn_registration);

        this.updateView();

        btn_regis.setOnClickListener(v -> {

            if(fieldsValidator()){
                if(password1.getEditText().getText().toString()
                        .equals(password2.getEditText().getText().toString())){

                    CustomerDTO customer = new CustomerDTO();
                    customer.setLogin(username.getEditText().getText().toString());
                    customer.setPassword(password1.getEditText().getText().toString());

                    ProfileDTO profile = new ProfileDTO();
                    profile.setName(name.getEditText().getText().toString());
                    profile.setCpf(cpf.getEditText().getText().toString());
                    profile.setPhone(phone.getEditText().getText().toString());
                    profile.setAnimalType(convertAnymalTypeValue());


                    if(USER_TYPE.equals("petOwner")){

                        Call<Void> call = new RetrofitConfig().getPetOwnerService().register(customer);

                        Call<CustomerDTO> callGetCustomerId = new RetrofitConfig().getPetOwnerService().getByUsername(customer.getLogin());
                        Call<Void> callSaveProfile = new RetrofitConfig().getProfileService().register(profile);

                        call.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {

                                callGetCustomerId.enqueue(new Callback<CustomerDTO>() {
                                    @Override
                                    public void onResponse(Call<CustomerDTO> call, Response<CustomerDTO> response) {

                                        customer.setId(response.body().getId());
                                        profile.setCustomer(customer);


                                        callSaveProfile.enqueue(new Callback<Void>() {
                                            @Override
                                            public void onResponse(Call<Void> call, Response<Void> response) {
                                                Toast.makeText(SignUpActivity2.this,
                                                        "Cadastro concluido!",
                                                        Toast.LENGTH_LONG).show();

                                                Intent intent = new Intent(SignUpActivity2.this, LoginActivity.class);
                                                startActivity(intent);
                                            }

                                            @Override
                                            public void onFailure(Call<Void> call, Throwable t) {
                                                Log.e("Erro:   ", t.getMessage());
                                            }
                                        });


                                    }

                                    @Override
                                    public void onFailure(Call<CustomerDTO> call, Throwable t) {
                                        Log.e("Erro:   ", t.getMessage());
                                    }
                                });

                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.e("Erro:   ", t.getMessage());
                            }
                        });





                    }else{


                        Call<Void> call = new RetrofitConfig().getPetSitterService().register(customer);

                        Call<CustomerDTO> callGetCustomerId = new RetrofitConfig().getPetSitterService().getByUsername(customer.getLogin());
                        Call<Void> callSaveProfile = new RetrofitConfig().getProfileService().register(profile);

                        call.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {

                                callGetCustomerId.enqueue(new Callback<CustomerDTO>() {
                                    @Override
                                    public void onResponse(Call<CustomerDTO> call, Response<CustomerDTO> response) {

                                        customer.setId(response.body().getId());
                                        profile.setCustomer(customer);


                                        callSaveProfile.enqueue(new Callback<Void>() {
                                            @Override
                                            public void onResponse(Call<Void> call, Response<Void> response) {
                                                Toast.makeText(SignUpActivity2.this,
                                                        "Cadastro concluido!",
                                                        Toast.LENGTH_LONG).show();

                                                Intent intent = new Intent(SignUpActivity2.this, LoginActivity.class);
                                                startActivity(intent);
                                            }

                                            @Override
                                            public void onFailure(Call<Void> call, Throwable t) {
                                                Log.e("Erro:   ", t.getMessage());
                                            }
                                        });


                                    }

                                    @Override
                                    public void onFailure(Call<CustomerDTO> call, Throwable t) {
                                        Log.e("Erro:   ", t.getMessage());
                                    }
                                });

                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.e("Erro:   ", t.getMessage());
                            }
                        });

                    }

                }else{
                    Toast.makeText(this, "As senhas não coincidem! " +
                                                    "Favor verificar os campos (Senha) e (Confirmar Senha).",
                            Toast.LENGTH_LONG).show();
                }


            }else{
                Toast.makeText(this, "Por favor, Preencha todos os dados de perfil e selecione pelo menos 1 tipo de animal.",
                        Toast.LENGTH_LONG).show();
            }

        });

    }

    private String convertAnymalTypeValue() {
        if(sw_cat.isChecked() && sw_dog.isChecked()){
            return "BOTH";
        }else if(sw_cat.isChecked()){
            return "CAT";
        }
        return "DOG";
    }


    @Override
    protected void onResume() {
        super.onResume();
        this.updateView();

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
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public boolean fieldsValidator(){
        if( !(name.getEditText().getText().toString().isEmpty()) &&
                !(cpf.getEditText().getText().toString().isEmpty()) &&
                !(phone.getEditText().getText().toString().isEmpty()) &&
                !(password1.getEditText().getText().toString().isEmpty()) &&
                !(password2.getEditText().getText().toString().isEmpty()) &&
                (sw_cat.isChecked() || sw_dog.isChecked())){
            return true;
        }
        return false;
    }
}