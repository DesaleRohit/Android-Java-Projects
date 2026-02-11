package com.rohit.call_and_sms_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Sms_Activity extends AppCompatActivity {
    EditText enterNum , enterText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_layout);

        enterNum = findViewById(R.id.enterNum);
        enterText = findViewById(R.id.enterText);
    }

    public void makeSms(View v) {
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("smsto:" + enterNum.getText().toString()));
        i.putExtra("sms_body", enterText.getText().toString());
        startActivity(i);
    }
}
