package com.rohit.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Intent_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_layout);
    }
    public void goNext(View view) {
        Intent i = new Intent(Intent_Activity.this,Second_Activity.class);
        startActivity(i);
    }
}