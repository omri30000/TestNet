package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    private EditText usernameEt;
    private EditText passwordEt;
    private EditText emailEt;
    private Button teacherBtn;
    private Button studentBtn;

    private DatabaseReference myRef;
    private String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        this.usernameEt = findViewById(R.id.usernamePT);
        this.passwordEt = findViewById(R.id.passwordPT);
        this.emailEt = findViewById(R.id.emailPT);

        this.teacherBtn = findViewById(R.id.teacherBtn);
        this.studentBtn = findViewById(R.id.studentBtn);

        this.myRef = FirebaseDatabase.getInstance().getReference();
        this.userType = "None";
    }

    public void studentBtnClicked(View view) {
        this.studentBtn.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        this.teacherBtn.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));

        this.userType = "Student";
    }

    public void teacherBtnClicked(View view) {
        this.studentBtn.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        this.teacherBtn.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));

        this.userType = "Teacher";
    }

    /**
     * The function will insert a new user to the database and move him to the menu
     * @param view the button from which the click came
     */
    public void sendBtnClicked(View view) {
        String username, password, email, userIdentifier;
        username = this.usernameEt.getText().toString();
        password = this.passwordEt.getText().toString();
        email = this.emailEt.getText().toString();

        User user = new User(username, password, email, this.userType);

        if (isDetailsValid(user)){
            userIdentifier = this.myRef.child("users").push().getKey();
            this.myRef.child("users").child(userIdentifier).setValue(user);
        }
        else{
            Toast.makeText(this, "Invalid details", Toast.LENGTH_SHORT).show();
            return;
        }

        ((Config)getApplication()).setUserIdentifier(userIdentifier);

        //move to students\teachers menu
        if (this.userType.equals("Student"))
        {
            Intent i = new Intent(SignupActivity.this, StudentMenuActivity.class);
            i.putExtra("userIdentifier", userIdentifier); // todo: remove this and use Config instead
            startActivity(i);
        }
        else if (this.userType.equals("Teacher"))
        {
            Intent i = new Intent(SignupActivity.this, TeacherMenuActivity.class);
            i.putExtra("userIdentifier", userIdentifier); // todo: remove this and use Config instead
            startActivity(i);
        }
    }

    /**
     * The method will check if the user's input is valid
     * @return true or false according to the user's input's validity
     */
    private boolean isDetailsValid(User user) {
        if (this.userType.equals("None")) return false;
        //todo: check given values of username, password, email (maybe with RegEx?)
        return true;
    }
}
