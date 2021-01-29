package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    private EditText usernameEt;
    private EditText passwordEt;
    private EditText emailEt;
    private Button teacherBtn;
    private Button studentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        this.usernameEt = findViewById(R.id.usernamePT);
        this.passwordEt = findViewById(R.id.passwordPT);
        this.emailEt = findViewById(R.id.emailPT);

        this.teacherBtn = findViewById(R.id.teacherBtn);
        this.studentBtn = findViewById(R.id.studentBtn);
    }


    public void studentBtnClicked(View view) {
        this.studentBtn.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        this.teacherBtn.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
    }

    public void teacherBtnClicked(View view) {
        this.studentBtn.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        this.teacherBtn.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
    }


    public void sendBtnClicked(View view) {
        //move to students\teachers menu

        Intent i = new Intent(SignupActivity.this, TeacherMenuActivity.class);
        startActivity(i);

        Intent j = new Intent(SignupActivity.this, StudentMenuActivity.class);
        startActivity(j);
    }
}
