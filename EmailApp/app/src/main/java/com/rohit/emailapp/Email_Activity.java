package com.rohit.emailapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Email_Activity extends AppCompatActivity {

    EditText txtEmailAddress , txtEmailSubject , txtEmailMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_layout);

        txtEmailAddress = findViewById(R.id.txtEmailAddress);
        txtEmailSubject = findViewById(R.id.txtEmailSubject);
        txtEmailMessage = findViewById(R.id.txtEmailMessage);
    }

    public void sendMail(View v) {
        String[] email = { txtEmailAddress.getText().toString() };

        Intent i = new Intent(Intent.ACTION_SENDTO);

        i.putExtra(Intent.EXTRA_EMAIL,email);
        i.putExtra(Intent.EXTRA_SUBJECT, txtEmailSubject.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT, txtEmailMessage.getText().toString());

        startActivity(Intent.createChooser(i,"Email Apps"));
    }

}
