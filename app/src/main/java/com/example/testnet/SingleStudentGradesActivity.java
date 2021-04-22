package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SingleStudentGradesActivity extends AppCompatActivity {
    private ArrayList<String> testsArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_student_grades);

        ListView testsLv = findViewById(R.id.SingleStudentGradesLV);
        this.testsArr = new ArrayList<String>();

        fillExamsNames();

        ArrayAdapter<String> namesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.testsArr);
        testsLv.setAdapter(namesAdapter);

        testsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //todo: get grade from the database
                Toast.makeText(SingleStudentGradesActivity.this, "Your grade is: 100", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void backBtnClicked(View view) {
        Intent i = new Intent(SingleStudentGradesActivity.this, StudentMenuActivity.class);
        startActivity(i);
    }

    public void fillExamsNames(){
        String s = "Exam 1";
        this.testsArr.add(s);

        s = "Exam 2";
        this.testsArr.add(s);

        s = "Exam 3";
        this.testsArr.add(s);

        s = "Exam 4";
        this.testsArr.add(s);
    }
}
