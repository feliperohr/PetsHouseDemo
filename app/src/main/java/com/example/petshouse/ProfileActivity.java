package com.example.petshouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petshouse.model.dto.CustomerDTO;
import com.google.gson.Gson;

public class ProfileActivity extends AppCompatActivity {

    private Toolbar menu;

    private TextView name;
    private TextView phone;
    private TextView cpf;
    private TextView animalType;

    private GridView gridView;
    private ImageView profile_img;

    int[] images = {
            R.drawable.pet1,
            R.drawable.pet2,
            R.drawable.pet3,
            R.drawable.pet4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        CustomerDTO customer = getCustomerData();

        menu = findViewById(R.id.menu);
        setSupportActionBar(menu);
        menu.setTitle(customer.getLogin());

        name = findViewById(R.id.txt_profile_name);
        phone = findViewById(R.id.txt_profile_phone);
        cpf = findViewById(R.id.txt_profile_cpf);
        animalType = findViewById(R.id.txt_profile_animal);
        profile_img = findViewById(R.id.image_profile);

        profile_img.setImageResource(R.drawable.i3);

        gridView = findViewById(R.id.images_grid);

        CustomAdapter customAdapter = new CustomAdapter(images, this);
        gridView.setAdapter(customAdapter);

//        Toast.makeText(this, name.getText(), Toast.LENGTH_LONG).show();

        loadCustomerData(customer);
    }

    private void loadCustomerData(CustomerDTO customerDTO) {
        name.setText(customerDTO.getProfile().getName());
        phone.setText(customerDTO.getProfile().getPhone());
        cpf.setText(customerDTO.getProfile().getCpf());
        animalType.setText(changeAnimalType(customerDTO.getProfile().getAnimalType()));

    }

    public class CustomAdapter extends BaseAdapter{

        private int[] imagesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(int[] imagesPhoto, Context context) {
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view == null){
                view = layoutInflater.inflate(R.layout.row_image, viewGroup, false);
            }

            ImageView imagePhoto = view.findViewById(R.id.row_image_view);

            imagePhoto.setImageResource(imagesPhoto[i]);

            return view;
        }
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
            case R.id.notification:
                Intent intent2 = new Intent(this, NotificationActivity.class);
                startActivity(intent2);
                return true;
            case R.id.task:
                Intent intent3 = new Intent(this, TaskActivity.class);
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

    private CustomerDTO getCustomerData(){
        SharedPreferences sharedPreferences = getSharedPreferences("customerData", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("CustomerDTO", "");
        CustomerDTO customer = gson.fromJson(json, CustomerDTO.class);
        return customer;
    }

    private String changeAnimalType(String type){
        switch (type){
            case "BOTH":
                return "Cão e Gato";
            case "CAT":
                return "Gato";
            case "DOG":
                return "Cão";
        }

        return "null";
    }
}