package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeacherMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_menu);
    }

    public void createExamClicked(View view) {
        Intent i = new Intent(TeacherMenuActivity.this, CreateExamActivity.class);
        startActivity(i);
    }

    public void myExamsClicked(View view) {
        Intent i = new Intent(TeacherMenuActivity.this, MyExamsActivity.class);
        startActivity(i);
    }

    public void logoutClicked(View view) {
        ((Config)getApplication()).setUserIdentifier("null");
        Intent i = new Intent(TeacherMenuActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
