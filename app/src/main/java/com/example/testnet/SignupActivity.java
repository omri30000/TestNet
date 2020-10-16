package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void sendBtnClicked(View view) {
        //move to students\teachers menu

        Intent i = new Intent(SignupActivity.this, TeacherMenuActivity.class);
        startActivity(i);

        Intent j = new Intent(SignupActivity.this, StudentMenuActivity.class);
        startActivity(j);
    }
}
