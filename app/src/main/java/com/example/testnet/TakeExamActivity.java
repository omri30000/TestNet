package com.example.testnet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TakeExamActivity extends AppCompatActivity {
    private ListView questionsLv;
    private ArrayList<Question> questionArr;
    private String examId;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_exam);

        Intent intent = getIntent();
        this.examId = intent.getStringExtra("examId");

        this.myRef = FirebaseDatabase.getInstance().getReference();

        this.questionsLv = findViewById(R.id.takeQuestionsLV);
        this.questionArr = new ArrayList<Question>();

        getQuestionData();
    }

    public void submitBtnClicked(View view) {
        Intent i = new Intent(TakeExamActivity.this, StudentMenuActivity.class);
        startActivity(i);
    }

    public void getQuestionData(){

        Query q = this.myRef.child("exams").child(this.examId).child("questions").orderByKey();

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dst : dataSnapshot.getChildren()) {
                    Question question = dst.getValue(Question.class);
                    questionArr.add(question);
                }
                startExam();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void startExam(){
        QuestionToAnswerAdapter questionAdapter = new QuestionToAnswerAdapter(this, R.layout.question_to_answer, this.questionArr);
        this.questionsLv.setAdapter(questionAdapter);
    }
}
