package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JoinExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_exam);
    }

    public void sendBtnClicked(View view) {
        Intent i = new Intent(JoinExamActivity.this, TakeExamActivity.class);
        //todo: i.putExtras()
        startActivity(i);
    }
}
