package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void sendBtnClicked(View view) {
        //move to students\teachers menu

        Intent i = new Intent(LoginActivity.this, TeacherMenuActivity.class);
        startActivity(i);

        Intent j = new Intent(LoginActivity.this, StudentMenuActivity.class);
        startActivity(j);
    }

    public void signupBtnClicked(View view) {
        //move to signup activity
        Intent i = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(i);
    }
}
