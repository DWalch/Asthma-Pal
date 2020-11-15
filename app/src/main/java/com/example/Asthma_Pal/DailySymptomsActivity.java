package com.example.Asthma_Pal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class DailySymptomsActivity extends AppCompatActivity {

    private ChipGroup cough, wheeze, chest, sleep, exercise, meds;
    private Chip coughsel, wheezesel, chestsel, sleepsel, exercisesel, medssel;
    private Button submit;
    private String strcoughsel, strwheezesel, strchestsel, strsleepsel, strexercisesel, strmedssel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_symptoms);

        cough = findViewById(R.id.chgCoughAnswer);
        wheeze = findViewById(R.id.chgWheezeAnswer);
        chest = findViewById(R.id.chgSleepAnswer);
        sleep = findViewById(R.id.chgTightChestAnswer);
        exercise = findViewById(R.id.chgStopExcerAnswer);
        meds = findViewById(R.id.chgRescueMed);
        submit = findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coughsel = findViewById(cough.getCheckedChipId());
                strcoughsel = coughsel.getText().toString();
                wheezesel = findViewById(wheeze.getCheckedChipId());
                strwheezesel = wheezesel.getText().toString();
                chestsel = findViewById(chest.getCheckedChipId());
                strchestsel = chestsel.getText().toString();
                sleep = findViewById(sleep.getCheckedChipId());
                strsleepsel = sleepsel.getText().toString();
                exercisesel = findViewById(exercise.getCheckedChipId());
                strexercisesel = exercisesel.getText().toString();
                medssel = findViewById(meds.getCheckedChipId());
                strmedssel = medssel.getText().toString();

                if(strcoughsel.isEmpty() || strwheezesel.isEmpty() || strchestsel.isEmpty() || strsleepsel.isEmpty() || strexercisesel.isEmpty() || strmedssel.isEmpty()){
                    Toast.makeText(DailySymptomsActivity.this, "Please make sure all fields are\nfilled before continuing ", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Need to figure out how to save entries


                    Intent intent = new Intent(DailySymptomsActivity.this, DailyEntryActivity.class);
                    DailyEntryActivity.DA.finish();
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}