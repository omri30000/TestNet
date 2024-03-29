package com.example.testnet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class JoinExamActivity extends AppCompatActivity {
    private EditText examIdEt;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_exam);

        this.examIdEt = findViewById(R.id.EnterExamIdPT);

        this.myRef = FirebaseDatabase.getInstance().getReference();
    }

    public void sendBtnClicked(View view) {
        String examId = this.examIdEt.getText().toString();

        this.myRef.child("exams").child(examId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    // exam exists in the database
                    Intent i = new Intent(JoinExamActivity.this, TakeExamActivity.class);
                    i.putExtra("examId", dataSnapshot.getKey());
                    startActivity(i);
                }
                else{
                    Log.d("Error", "exam identifier is invalid");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
