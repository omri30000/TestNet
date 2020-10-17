package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SingleStudentGradesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_student_grades);
    }

    public void backBtnClicked(View view) {
        Intent i = new Intent(SingleStudentGradesActivity.this, StudentMenuActivity.class);
        startActivity(i);
    }
}
