package com.example.asthmapal;
/*
COMP3540 Human Computer Interaction
Asthma Pal
Doug Walch T00536730
Date: November 5th 2020
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asthmapal.ui.login.LoginScreen;

public class MainActivity extends AppCompatActivity {

    private Button mBtLaunchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToActivity(View view)
    {
        Intent intent = new Intent(this, AddPhsyicianInfo.class);
        startActivity(intent);
    }
}