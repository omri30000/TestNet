package com.example.testnet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEt;
    private EditText passwordEt;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.usernameEt = findViewById(R.id.loginUsernameEt);
        this.passwordEt = findViewById(R.id.loginPasswordEt);

        this.myRef = FirebaseDatabase.getInstance().getReference();
    }

    /**
     * The method will authenticate a known user and move him to the menu
     * @param view the button from which the click came
     */
    public void sendBtnClicked(View view) {
        final String username, password;

        try {
            username = String.valueOf(this.usernameEt.getText());
            password = String.valueOf(this.passwordEt.getText());

            this.usernameEt.setText("");
            this.passwordEt.setText("");
            //todo: add details validation, consider using RegEx
        }
        catch (Exception e) {
            Toast.makeText(this, "Invalid name or password", Toast.LENGTH_SHORT).show();
            return;
        }

        Query q = this.myRef.child("users").orderByValue();

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userIdentifier = "null";
                for (DataSnapshot dst : dataSnapshot.getChildren()) {
                    User user = dst.getValue(User.class);

                    if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                        userIdentifier = dst.getKey();

                        ((Config)getApplication()).setUserIdentifier(userIdentifier);

                        if (user.getUserType().equals("Teacher"))
                        {
                            Intent i = new Intent(LoginActivity.this, TeacherMenuActivity.class);
                            i.putExtra("userIdentifier", userIdentifier); // todo: remove this and use Config instead
                            startActivity(i);
                        }
                        else if (user.getUserType().equals("Student"))
                        {
                            Intent j = new Intent(LoginActivity.this, StudentMenuActivity.class);
                            j.putExtra("userIdentifier", userIdentifier); // todo: remove this and use Config instead
                            startActivity(j);
                        }
                    }
                }

                if (userIdentifier.equals("null")){
                    Toast.makeText(LoginActivity.this, "user doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /**
     * The method will move the client to sign up activity
     * @param view the button from which the click came
     */
    public void signupBtnClicked(View view) {
        Intent i = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(i);

    }
}
