package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TakeExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_exam);
    }

    public void submitBtnClicked(View view) {
        Intent i = new Intent(TakeExamActivity.this, StudentMenuActivity.class);
        //todo: i.putExtras()
        startActivity(i);
    }
}
