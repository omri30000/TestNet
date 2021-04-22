package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/*
The activity will show the teacher all of his students' grades in a specific exam (get ExamID from intent)
*/
public class AllStudentsGradesActivity extends AppCompatActivity {

    private ArrayList<String> namesArr;

    private String examName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_students_grades);

        this.examName = (String) getIntent().getExtras().get("examName");

        TextView titleTv = findViewById(R.id.examNameTV);
        titleTv.setText(this.examName);

        ListView studentsLv = findViewById(R.id.allGradesLV);
        this.namesArr = new ArrayList<String>();

        fillStudentsNames();

        ArrayAdapter<String> namesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.namesArr);
        studentsLv.setAdapter(namesAdapter);

        studentsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //todo: get grade from the database
                Toast.makeText(AllStudentsGradesActivity.this, "Student's grade is: 100", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void backBtnClicked(View view) {
        Intent i = new Intent(AllStudentsGradesActivity.this, ExamForResultsActivity.class);
        startActivity(i);
    }

    public void fillStudentsNames(){
        String s = "Student 1";
        this.namesArr.add(s);

        s = "Student 2";
        this.namesArr.add(s);

        s = "Student 3";
        this.namesArr.add(s);

        s = "Student 4";
        this.namesArr.add(s);
    }
}
