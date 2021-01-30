package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeacherMenuActivity extends AppCompatActivity {

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_menu);

        this.userId = (String) getIntent().getExtras().get("userIdentifier");
    }

    public void createExamClicked(View view) {
        Intent i = new Intent(TeacherMenuActivity.this, CreateExamActivity.class);
        i.putExtra("userIdentifier", this.userId);
        startActivity(i);
    }

    public void watchGradesClicked(View view) {
        Intent i = new Intent(TeacherMenuActivity.this, ExamForResultsActivity.class);
        i.putExtra("userIdentifier", this.userId);
        startActivity(i);
    }

    public void logoutClicked(View view) {
        Intent i = new Intent(TeacherMenuActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
