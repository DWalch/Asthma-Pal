package com.example.Asthma_Pal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InformationActivity extends AppCompatActivity {

    private String filename = "PersonalInformation";
    private TextView textViewCountry, textViewFirstName, textViewLastName, textViewPhone, textViewEmail;
    private SharedPreferences mPreferences;
    private Button physinfo;
    private String sharedPrefFile = "com.example.Asthma_Pal.sharedPreferences";
    private String defVal = "NULL";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        int phonenum = 0;

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        physinfo = findViewById(R.id.btnPhysInfo);
        textViewCountry = findViewById(R.id.txtCountry);
        textViewFirstName = findViewById(R.id.txtFirstName);
        textViewLastName = findViewById(R.id.txtLastName);
        textViewPhone = findViewById(R.id.txtPhoneNumber);
        textViewEmail = findViewById(R.id.txtEmail);


        textViewPhone.setText(mPreferences.getString("com.example.Asthma_Pal.phone", defVal));
        textViewCountry.setText(mPreferences.getString("com.example.Asthma_Pal.Country", defVal));
        textViewFirstName.setText(mPreferences.getString("com.example.Asthma_Pal.FirstName", defVal));
        textViewLastName.setText(mPreferences.getString("com.example.Asthma_Pal.LastName", defVal));
        textViewPhone.setText(phonenum);
        textViewEmail.setText(mPreferences.getString("com.example.Asthma_Pal.Email", defVal));
/*
        physinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent physInformation = new Intent(InformationActivity.this, PhysicianInformation.class);
                startActivity(physInformation);
            }
        });
*/
    }
}