package com.rohit.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login_Activity extends AppCompatActivity {
    
    EditText txtUsername , txtPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
    }
    
    public void click(View v) {
        if (txtUsername.getText().toString().equalsIgnoreCase("Admin") 
                && txtPassword.getText().toString().equalsIgnoreCase("1234"))
        {
            Intent i = new Intent(Login_Activity.this,Menu_Activity.class);
            startActivity(i);
        } else {
            Toast.makeText(Login_Activity.this, "Invalide Username or Password", Toast.LENGTH_SHORT).show();
        }
    }
}
