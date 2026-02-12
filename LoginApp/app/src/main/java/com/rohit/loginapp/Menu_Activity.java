package com.rohit.loginapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Menu_Activity extends AppCompatActivity {

    TextView txtGetName , txtGetMobile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        txtGetName = findViewById(R.id.txtGetName);
        txtGetMobile = findViewById(R.id.txtGetMobile);

        String name = getIntent().getStringExtra("Name");
        String mobile = getIntent().getStringExtra("Mobile");

        txtGetName.setText("Name:"+ name);
        txtGetMobile.setText("Mobile:"+ mobile);

    }
}
