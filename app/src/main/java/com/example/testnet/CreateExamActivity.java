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
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CreateExamActivity extends AppCompatActivity implements View.OnClickListener{

    private int grade;

    private Button saveBtn;
    private Button plusBtn;

    private EditText quest;
    private EditText ans1;
    private EditText ans2;
    private EditText ans3;
    private EditText ans4;
    private Button addQuestionBtn;

    private ArrayList<Question> questions;
    private ArrayList<String> answers;
    private ListView questionsLv;

    private DatabaseReference myRef;

    Dialog d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam);

        this.myRef = FirebaseDatabase.getInstance().getReference();

        this.saveBtn = findViewById(R.id.saveBtn);
        this.plusBtn = findViewById(R.id.addQuestionBtn);
        this.questionsLv = findViewById(R.id.questionsLV);

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
            String userId = ((Config)getApplication()).getUserIdentifier();
            String examId = this.myRef.child("users").push().getKey();

            this.myRef.child("exams").child(examId).child("creator").setValue(userId);
            this.myRef.child("exams").child(examId).child("questions").setValue(this.questions);

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

            this.refreshList();
            //Toast.makeText(this, this.questions.get(this.questions.size()-1).toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void refreshList(){
        QuestionToViewAdapter questionAdapter = new QuestionToViewAdapter(this, R.layout.question_to_view, this.questions);
        this.questionsLv.setAdapter(questionAdapter);
    }


}
