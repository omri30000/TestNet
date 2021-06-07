package com.example.testnet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SingleStudentGradesActivity extends AppCompatActivity {
    private ArrayList<String> testsArr;
    private ArrayList<String> gradesArr;
    private ListView testsLv;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_student_grades);

        this.myRef = FirebaseDatabase.getInstance().getReference();

        this.testsLv = findViewById(R.id.SingleStudentGradesLV);
        this.testsArr = new ArrayList<String>();
        this.gradesArr = new ArrayList<String>();

        fillExamsNames();

    }

    public void backBtnClicked(View view) {
        Intent i = new Intent(SingleStudentGradesActivity.this, StudentMenuActivity.class);
        startActivity(i);
    }

    public void fillExamsNames(){
        Query q = this.myRef.child("users").child(((Config)getApplication()).getUserIdentifier()).child("grades").orderByKey();

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dst : dataSnapshot.getChildren()) {
                    testsArr.add(dst.getKey());
                    gradesArr.add(dst.getValue(String.class));
                }
                fillGradesList();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void fillGradesList(){
        ArrayAdapter<String> namesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.testsArr);
        this.testsLv.setAdapter(namesAdapter);

        testsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get grade from the database
                Toast.makeText(SingleStudentGradesActivity.this, "Your grade is: " + gradesArr.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
