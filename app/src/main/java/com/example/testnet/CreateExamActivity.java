package com.example.testnet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class CreateExamActivity extends AppCompatActivity {

    private String userId;
    private String m_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam);

        this.userId = (String) getIntent().getExtras().get("userIdentifier");
    }

    public void saveBtnClicked(View view) {
        Intent i = new Intent(CreateExamActivity.this, TeacherMenuActivity.class);
        i.putExtra("userIdentifier", this.userId);
        startActivity(i);
    }

    public void addQuestionBtnClicked(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Create new question");

        builder.setView(R.layout.question_to_create);


        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //m_Text = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();

        /*EditText quest = alert.findViewById(R.id.questionEt);
        EditText ans1 = alert.findViewById(R.id.answer1Et);
        EditText ans2 = alert.findViewById(R.id.answer2Et);
        EditText ans3 = alert.findViewById(R.id.answer3Et);
        EditText ans4 = alert.findViewById(R.id.answer4Et);*/
        builder.setTitle("blabla");
        alert.show();

        /*
        //builder.show();
        final QuestionToCreateDialog dialog = new QuestionToCreateDialog(CreateExamActivity.this);
        dialog.show();
        */

    }
}
