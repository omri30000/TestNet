package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/*
The activity will show the teacher all of his students' grades in a specific exam (get ExamID from intent)
*/
public class AllStudentsGradesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_students_grades);
    }
}
