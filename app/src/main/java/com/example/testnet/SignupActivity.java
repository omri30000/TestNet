package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText usernameEt;
    private EditText passwordEt;
    private EditText emailEt;
    private Button teacherBtn;
    private Button studentBtn;

    private IDBManager fbManager;
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

        this.fbManager = new FirebaseManager();
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

    public void sendBtnClicked(View view) {
        String username, password, email;
        username = this.usernameEt.getText().toString();
        password = this.passwordEt.getText().toString();
        email = this.emailEt.getText().toString();

        try{
            this.fbManager.insertUser(new User(username, password, email, this.userType));
        }
        catch (Exception exception)
        {
            Toast.makeText(this, "Invalid details", Toast.LENGTH_SHORT).show();
            return;
        }

        //move to students\teachers menu
        if (this.userType.equals("Student"))
        {
            Intent i = new Intent(SignupActivity.this, StudentMenuActivity.class);
            i.putExtra("userIdentifier", "12345"); // todo: add the real userId here
            startActivity(i);
        }
        else if (this.userType.equals("Teacher"))
        {
            Intent i = new Intent(SignupActivity.this, TeacherMenuActivity.class);
            i.putExtra("userIdentifier", "12345"); // todo: add the real userId here
            startActivity(i);
        }
    }

    /**
     * The method will check if the user's input is valid
     * @return true or false according to the user's input's validity
     */
    private boolean isDetailsValid() {
        if (this.userType.equals("None")) return false;
        //todo: check given values of username, password, email (maybe with RegEx?)
        return true;
    }
}
