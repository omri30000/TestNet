package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);
    }

    public void takeExamClicked(View view) {
        Intent i = new Intent(StudentMenuActivity.this, JoinExamActivity.class);
        startActivity(i);
    }

    public void watchGradesClicked(View view) {
        Intent i = new Intent(StudentMenuActivity.this, SingleStudentGradesActivity.class);
        startActivity(i);
    }

    public void logoutClicked(View view) {
        Intent i = new Intent(StudentMenuActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
