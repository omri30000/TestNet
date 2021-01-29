package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEt;
    private EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.usernameEt = findViewById(R.id.loginUsernameEt);
        this.passwordEt = findViewById(R.id.loginPasswordEt);
    }

    public void sendBtnClicked(View view) {
        String username, password;
        try {
            username = String.valueOf(this.usernameEt.getText());
            password = String.valueOf(this.passwordEt.getText());
            //todo: add details validation, consider using RegEx
        }
        catch (Exception e) {
            Toast t = Toast.makeText(this, "Invalid name or password", Toast.LENGTH_SHORT);
            t.show();
            this.usernameEt.setText("");
            this.passwordEt.setText("");
            return;
        }

        //todo: find user in the database

        //move to students\teachers menu
        if (true) //todo: move to teacher/student according to the details from the database
        {
            Intent i = new Intent(LoginActivity.this, TeacherMenuActivity.class);
            startActivity(i);
        }
        else
        {
            Intent j = new Intent(LoginActivity.this, StudentMenuActivity.class);
            startActivity(j);
        }
    }

    public void signupBtnClicked(View view) {
        //move to signup activity
        Intent i = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(i);
    }
}
