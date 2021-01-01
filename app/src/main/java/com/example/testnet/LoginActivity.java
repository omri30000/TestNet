package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEt;
    private EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.usernameEt.findViewById(R.id.loginUsernameEt);
        this.passwordEt.findViewById(R.id.loginPasswordEt);
    }

    public void sendBtnClicked(View view) {
        try {
            String username = String.valueOf(this.usernameEt.getText());
            String password = String.valueOf(this.passwordEt.getText());


        }
        catch (Exception e) {
            this.usernameEt.setText("Invalid name or password");
            return;
        }
        //check in the database



        //move to students\teachers menu
        Intent i = new Intent(LoginActivity.this, TeacherMenuActivity.class);
        startActivity(i);

        Intent j = new Intent(LoginActivity.this, StudentMenuActivity.class);
        startActivity(j);


    }

    public void signupBtnClicked(View view) {
        //move to signup activity
        Intent i = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(i);
    }
}
