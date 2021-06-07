package com.example.testnet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
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

/**
 * The activity presents a list of the pre made exams and allow a user to copy the exam identifier
 * to the clipboard by tapping on it's name
 */
public class MyExamsActivity extends AppCompatActivity {
    private ArrayList<String> testsNamesArr;
    private ArrayList<String> testsIDsArr;
    private ListView testsLv;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_exams);

        this.myRef = FirebaseDatabase.getInstance().getReference();

        this.testsLv = findViewById(R.id.MyExamsLV);
        this.testsNamesArr = new ArrayList<String>();
        this.testsIDsArr = new ArrayList<String>();

        fillExamsNames();

        testsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //copy to clipboard
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("exam id", testsIDsArr.get(position));
                assert clipboard != null;
                clipboard.setPrimaryClip(clip);
                
                Toast.makeText(MyExamsActivity.this, "exam ID was copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void backBtnClicked(View view) {
        Intent i = new Intent(MyExamsActivity.this, TeacherMenuActivity.class);
        startActivity(i);
    }

    public void fillExamsNames(){
        String userId = ((Config)getApplication()).getUserIdentifier();

        Query q = this.myRef.child("users").child(userId).child("exams").orderByKey();

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dst : dataSnapshot.getChildren()) {
                    testsNamesArr.add(dst.getKey());
                    testsIDsArr.add(String.valueOf(dst.getValue()));
                }
                setListView();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void setListView(){
        ArrayAdapter<String> namesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.testsNamesArr);
        this.testsLv.setAdapter(namesAdapter);
    }
}