package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentMenuActivity extends AppCompatActivity {

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);

        this.userId = (String) getIntent().getExtras().get("userIdentifier");
    }

    public void takeExamClicked(View view) {
        Intent i = new Intent(StudentMenuActivity.this, JoinExamActivity.class);
        i.putExtra("userIdentifier", this.userId);
        startActivity(i);
    }

    public void watchGradesClicked(View view) {
        Intent i = new Intent(StudentMenuActivity.this, SingleStudentGradesActivity.class);
        i.putExtra("userIdentifier", this.userId);
        startActivity(i);
    }

    public void logoutClicked(View view) {
        Intent i = new Intent(StudentMenuActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
