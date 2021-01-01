package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class TakeExamActivity extends AppCompatActivity {
    private ListView questionsLv;
    private ArrayList<QuestionToAnswer> questionArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_exam);

        this.questionsLv = findViewById(R.id.takeQuestionsLV);
        this.questionArr = new ArrayList<QuestionToAnswer>();

        getQuestionData();

        QuestionToAnswerAdapter questionAdapter = new QuestionToAnswerAdapter(this, R.layout.question_to_answer, this.questionArr);
        this.questionsLv.setAdapter(questionAdapter);
    }

    public void submitBtnClicked(View view) {
        Intent i = new Intent(TakeExamActivity.this, StudentMenuActivity.class);
        //todo: i.putExtras()
        startActivity(i);
    }

    public void getQuestionData(){
        QuestionToAnswer q = new QuestionToAnswer("aaa", "1", "2","3","4");
        this.questionArr.add(q);

        q = new QuestionToAnswer("bbb", "1", "2","3","4");
        this.questionArr.add(q);

        q = new QuestionToAnswer("ccc", "1", "2","3","4");
        this.questionArr.add(q);

        q = new QuestionToAnswer("ddd", "1", "2","3","4");
        this.questionArr.add(q);
    }
}
