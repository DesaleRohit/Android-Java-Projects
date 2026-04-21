package com.example.registrationpage;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declare views
    private EditText etFullName, etEmail, etPassword, etDob;
    private RadioGroup radioGroupGender;
    private Spinner spinnerCountry;
    private CheckBox chkReading, chkTraveling, chkSports, chkTerms;
    private Switch switchNewsletter;
    private Button btnRegister;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etDob = findViewById(R.id.etDob);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        chkReading = findViewById(R.id.chkReading);
        chkTraveling = findViewById(R.id.chkTraveling);
        chkSports = findViewById(R.id.chkSports);
        switchNewsletter = findViewById(R.id.switchNewsletter);
        chkTerms = findViewById(R.id.chkTerms);
        btnRegister = findViewById(R.id.btnRegister);
        tvResult = findViewById(R.id.tvResult);

        // Setup Spinner with countries from strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.countries_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);

        // DatePickerDialog for Date of Birth
        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        // Register button click handler
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        String formattedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        etDob.setText(formattedDate);
                    }
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    private void registerUser() {
        // Get values from widgets
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String dob = etDob.getText().toString().trim();

        // Gender
        int genderId = radioGroupGender.getCheckedRadioButtonId();
        String gender;
        if (genderId == R.id.rbMale) {
            gender = "Male";
        } else if (genderId == R.id.rbFemale) {
            gender = "Female";
        } else if (genderId == R.id.rbOther) {
            gender = "Other";
        } else {
            gender = "Not specified";
        }

        // Country
        String country = spinnerCountry.getSelectedItem().toString();

        // Hobbies
        List<String> hobbyList = new ArrayList<>();
        if (chkReading.isChecked()) hobbyList.add("Reading");
        if (chkTraveling.isChecked()) hobbyList.add("Traveling");
        if (chkSports.isChecked()) hobbyList.add("Sports");
        String hobbiesText = hobbyList.isEmpty() ? "None" : TextUtils.join(", ", hobbyList);

        String newsletter = switchNewsletter.isChecked() ? "Yes" : "No";
        boolean termsAccepted = chkTerms.isChecked();

        // Validation
        if (fullName.isEmpty()) {
            etFullName.setError("Name required");
            return;
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Valid email required");
            return;
        }
        if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            return;
        }
        if (dob.isEmpty()) {
            etDob.setError("Please select date of birth");
            return;
        }
        if (country.equals("Select Country")) {
            Toast.makeText(this, "Please select a valid country", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!termsAccepted) {
            Toast.makeText(this, "You must accept Terms & Conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        // Build success message
        String result = "Registration Successful!\n" +
                "Name: " + fullName + "\n" +
                "Email: " + email + "\n" +
                "DOB: " + dob + "\n" +
                "Gender: " + gender + "\n" +
                "Country: " + country + "\n" +
                "Hobbies: " + hobbiesText + "\n" +
                "Newsletter: " + newsletter;

        tvResult.setText(result);
        Toast.makeText(this, "Welcome " + fullName + "!", Toast.LENGTH_LONG).show();
    }
}

