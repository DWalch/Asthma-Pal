package com.example.Asthma_Pal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;

public class LoginActivity extends AppCompatActivity {

    private EditText Username, Password;
    private Button Login;
    private TextView Register;
    public static Activity RA;
    private FirebaseAuth LoginDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginDatabase = FirebaseAuth.getInstance();

        FirebaseUser user = LoginDatabase.getCurrentUser();

        /*if (user != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);;
            startActivity(intent);
            finish();
        }*/

        RA = this;
        Username = (EditText)findViewById(R.id.etUsername);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        Register = findViewById(R.id.tvRegister);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(register);
            }
        });
    }

    private void validate(String enterUser, String enterPass){

        LoginDatabase.signInWithEmailAndPassword(enterUser, enterPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);;
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(LoginActivity.this, "Unrecognized user, Please Try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}