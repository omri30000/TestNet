package com.example.testnet;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class QuestionToCreateDialog extends Dialog {

    private EditText quest;
    private EditText ans1;
    private EditText ans2;
    private EditText ans3;
    private EditText ans4;

    public QuestionToCreateDialog(final Context ctx) {
        super(ctx);

        this.setContentView(R.layout.question_to_create);
        this.setTitle("Create new question");
        this.setCancelable(true);

        this.quest = findViewById(R.id.questionEt);
        this.ans1 = findViewById(R.id.answer1Et);
        this.ans2 = findViewById(R.id.answer2Et);
        this.ans3 = findViewById(R.id.answer3Et);
        this.ans4 = findViewById(R.id.answer4Et);
    }

    public void saveBtnClicked(View view) {
        Question q = new Question(
            this.quest.getText().toString(),
                this.ans1.getText().toString(),
                this.ans2.getText().toString(),
                this.ans3.getText().toString(),
                this.ans4.getText().toString()
        );

        this.dismiss();
    }
}
