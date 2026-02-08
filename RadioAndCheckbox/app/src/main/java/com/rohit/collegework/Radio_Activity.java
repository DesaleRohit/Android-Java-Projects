package com.rohit.collegework;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Radio_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_layout);

        RadioGroup rg = findViewById(R.id.rbg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);

                Toast.makeText(Radio_Activity.this, "you have selected : "+rb.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });



        }

    public void checkBtn(View v) {
        CheckBox ckb =  (CheckBox) v;

        Toast.makeText(Radio_Activity.this, "Stream Selected : "+ckb.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
