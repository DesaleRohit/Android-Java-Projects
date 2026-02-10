package com.rohit.call_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
    }
    public void goNext(View v) {
        Intent i = new Intent(Dashboard_Activity.this, Call_Activity.class);
        startActivity(i);
    }
}
