package com.example.testnet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateExamActivity extends AppCompatActivity implements View.OnClickListener{

    private String m_Text;

    private Button saveBtn;
    private Button plusBtn;

    private EditText quest;
    private EditText ans1;
    private EditText ans2;
    private EditText ans3;
    private EditText ans4;
    private Button addQuestionBtn;

    private ArrayList<Question> questions;

    Dialog d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam);

        this.saveBtn = findViewById(R.id.saveBtn);
        this.plusBtn = findViewById(R.id.addQuestionBtn);

        this.saveBtn.setOnClickListener(this);
        this.plusBtn.setOnClickListener(this);

        this.questions = new ArrayList<Question>();
    }

    public void createQuestionDialog()
    {
        this.d = new Dialog(this);

        this.d.setTitle("Create question");
        this.d.setContentView(R.layout.question_to_create);
        this.d.setCancelable(true);

        this.quest = this.d.findViewById(R.id.questionEt);
        this.ans1 = this.d.findViewById(R.id.answer1Et);
        this.ans2 = this.d.findViewById(R.id.answer2Et);
        this.ans3 = this.d.findViewById(R.id.answer3Et);
        this.ans4 = this.d.findViewById(R.id.answer4Et);
        this.addQuestionBtn = this.d.findViewById(R.id.CreateQuestionBtn);
        this.addQuestionBtn.setOnClickListener(this);

        d.show();
    }

    @Override
    public void onClick(View v)
    {
        if (v==saveBtn)
        {
            //todo: save questions to database
            Intent i = new Intent(CreateExamActivity.this, TeacherMenuActivity.class);
            startActivity(i);
        }
        else if (v == plusBtn)
        {
            createQuestionDialog();
        }
        else if (v == addQuestionBtn)
        {
            this.questions.add(new Question(
                    this.quest.getText().toString(),
                    this.ans1.getText().toString(),
                    this.ans2.getText().toString(),
                    this.ans3.getText().toString(),
                    this.ans4.getText().toString()
            ));

            d.dismiss();

            Toast.makeText(this, this.questions.get(this.questions.size()-1).toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
