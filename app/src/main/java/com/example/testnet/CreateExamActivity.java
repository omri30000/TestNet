package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam);
    }

    public void saveBtnClicked(View view) {
        Intent i = new Intent(CreateExamActivity.this, TeacherMenuActivity.class);
        startActivity(i);
    }
}
