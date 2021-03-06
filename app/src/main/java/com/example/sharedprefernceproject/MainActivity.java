package com.example.sharedprefernceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    UserManager userManager;
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userManager = new UserManager(this);
        // ...........read :

        TextInputEditText fullNameET = findViewById(R.id.et_main_fullName);
        fullNameET.setText(userManager.getFullName());

        TextInputEditText emailET = findViewById(R.id.et_main_email);
        emailET.setText(userManager.getEmail());

        RadioGroup radioGroup = findViewById(R.id.radioGroup_main_gender);
        gender = userManager.getGender();
        if (gender.equalsIgnoreCase("male")){
            radioGroup.check(R.id.radioBtn_main_male);
        }else if(gender.equalsIgnoreCase("female")){
            radioGroup.check(R.id.radioBtn_main_female);
        }
        //....................

        Button saveBTN = findViewById(R.id.btn_main_save);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioBtn_main_male) {
                    gender = "male";
                } else {
                    gender = "female";
                }
            }
        });

        //.........save:
        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userManager.savedUserInformation(fullNameET.getText().toString(),
                        emailET.getText().toString(),
                        gender);
            }
        });
        //..............
    }
}