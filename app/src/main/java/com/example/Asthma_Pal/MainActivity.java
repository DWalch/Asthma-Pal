package com.example.Asthma_Pal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Logout, PersonalInformation, Journal, Chart, Medication, Settings;
    public static Activity RA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //create variables for all of the buttons to use with onclick listeners
        RA = this;
        Logout = (Button)findViewById(R.id.btnLogOut);
        PersonalInformation = (Button)findViewById(R.id.btnViewInformation);
        Journal = (Button)findViewById(R.id.btnViewJournal);
        Chart = (Button)findViewById(R.id.btnViewChart);
        Medication = (Button)findViewById(R.id.btnViewMeds);
        Settings = (Button)findViewById(R.id.btnSettings);

        //on click listener for the logout button, for now it just sends user to log-in page
        //IMPLEMENT: logout of firebase eventually
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(logout);
            }
        });

        //on click listener for user to go to their personal information page
        PersonalInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personalInfo = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(personalInfo);
            }
        });


        //on click listener for user to go to their journal entries
        Journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent journal = new Intent(MainActivity.this, JournalActivity.class);
                startActivity(journal);
            }
        });

        //on click listener for user to go view their peak flow chart
        Chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chart = new Intent(MainActivity.this, ChartActivity.class);
                startActivity(chart);
            }
        });
/*
        //onclick listener for user to go to their medication page
        Medication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent meds = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(meds);
            }
        });
*/
        //onclick listener for users to adjust settings
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(setting);
            }
        });
    }

}