package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
The activity will allow a teacher to choose an exam in order to watch his students' results in this exam
*/
public class ExamForResultsActivity extends AppCompatActivity {
    private ArrayList<String> testsArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_for_results);

        ListView testsLv = findViewById(R.id.ExForResultsLV);
        this.testsArr = new ArrayList<String>();

        fillExamsNames();

        ArrayAdapter<String> namesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.testsArr);
        testsLv.setAdapter(namesAdapter);

        testsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ExamForResultsActivity.this, AllStudentsGradesActivity.class);
                i.putExtra("examName", testsArr.get(position));
                startActivity(i);
            }
        });

    }

    public void backBtnClicked(View view) {
        Intent i = new Intent(ExamForResultsActivity.this, TeacherMenuActivity.class);
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
