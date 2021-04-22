package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinExamActivity extends AppCompatActivity {
    private EditText examIdEt;
    private Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_exam);

        this.examIdEt = findViewById(R.id.EnterExamIdPT);
        this.sendBtn = findViewById(R.id.startExamBtn);
    }

    public void sendBtnClicked(View view) {
        String examId = this.examIdEt.getText().toString();

        if (!isExamExist(examId))
        {
            Toast t = Toast.makeText(this, "Invalid Exam Identifier!", Toast.LENGTH_SHORT);
            t.show();

            return;
        }

        Intent i = new Intent(JoinExamActivity.this, TakeExamActivity.class);
        i.putExtra("examId", examId);
        startActivity(i);
    }

    /**
     * The function will check if the given exam id is valid and exists in the database
     * @param id - the given ID of a specific exam
     * @return true or false if the exam appears in the DB
     */
    private boolean isExamExist(String id)
    {
        //todo: check if the ID appears in the database and return the result
        return true;
    }
}
