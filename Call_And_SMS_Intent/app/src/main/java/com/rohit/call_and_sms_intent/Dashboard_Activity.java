package com.rohit.call_and_sms_intent;

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

    public void goToCall(View V) {
        Intent i = new Intent(Dashboard_Activity.this,Call_Activity.class);
        startActivity(i);
    }

    public void goToSms(View v) {
        Intent i = new Intent(Dashboard_Activity.this,Sms_Activity.class);
        startActivity(i);
    }

}
