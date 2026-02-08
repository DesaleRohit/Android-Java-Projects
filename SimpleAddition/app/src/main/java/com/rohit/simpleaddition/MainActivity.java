package com.rohit.simpleaddition;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1 = findViewById(R.id.num_1);
        EditText num2 = findViewById(R.id.num_2);
        Button button = findViewById(R.id.btnAdd);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = num1.getText().toString();
                String b = num2.getText().toString();

                int c = Integer.parseInt(a) + Integer.parseInt(b);

                Toast.makeText(
                        MainActivity.this,
                        "Addition is : " + c,
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}
