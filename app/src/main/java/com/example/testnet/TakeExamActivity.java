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
    private ArrayList<String> answers;

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
        this.answers = new ArrayList<String>();

        getQuestionData();
    }

    public void submitBtnClicked(View view) {
        QuestionToAnswerAdapter adapter = (QuestionToAnswerAdapter) this.questionsLv.getAdapter();
        int questionsAmount = adapter.getCount();

        //fill answers array
        for (int i = 0; i < questionsAmount; i++){
            View v = this.questionsLv.getChildAt(i).findViewById(R.id.optionsRG);
            try {
                this.answers.add(adapter.getAnswer(v));
            }
            catch (Exception e){
                Toast.makeText(this, "You must answer all questions!", Toast.LENGTH_SHORT).show();
            }

        }

        final int grade = calculateGrade();

        Query q = this.myRef.child("exams").child(this.examId).child("name");

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String examName = String.valueOf(dataSnapshot.getValue());
                //add grade to firebase
                myRef.child("users").child(((Config)getApplication()).getUserIdentifier()).child("grades").child(examName).setValue(String.valueOf(grade));

                Intent i = new Intent(TakeExamActivity.this, StudentMenuActivity.class);
                startActivity(i);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


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

    /**
     * The method will calculate the student's grade in the exam
     * @return the student's grade
     */
    public int calculateGrade(){
        //todo: make sure the calculation works
        int count = 0;

        for(int i = 0; i < this.questionArr.size(); i++){
            if (this.questionArr.get(i).isAnswerCorrect(this.answers.get(i))) count++;
        }

        return (count * 100) / this.questionArr.size();
    }
}
