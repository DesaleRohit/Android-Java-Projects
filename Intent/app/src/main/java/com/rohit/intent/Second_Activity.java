package com.rohit.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_intent_layout);
    }
    public void goBack(View view) {
        Intent i = new Intent(Second_Activity.this,Intent_Activity.class);
        startActivity(i);
    }
}
